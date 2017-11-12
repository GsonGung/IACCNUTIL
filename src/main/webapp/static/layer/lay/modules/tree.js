/**
 * 
 * @Name：layui.tree 树组件
 * @Author：贤心
 * @License：MIT
 * 
 */

layui.define('jquery', function(exports) {
	"use strict";

	var $ = layui.$, hint = layui.hint();

	var enterSkin = 'layui-tree-enter', Tree = function(options) {
		this.options = options;
	};

	// 图标
	var icon = {
		arrow : ['&#xe623;', '&#xe625;'] // 箭头
		,
		checkbox : ['&#xe626;', '&#xe627;'] // 复选框
		,
		radio : ['&#xe62b;', '&#xe62a;'] // 单选框
		,
		branch : ['&#xe622;', '&#xe624;'] // 父节点
		,
		leaf : '&#xe621;' // 叶节点
	};

	// 初始化
	Tree.prototype.init = function(elem) {
		var that = this;
		elem.addClass('layui-box layui-tree'); // 添加tree样式
		if (that.options.skin) {
			elem.addClass('layui-tree-skin-' + that.options.skin);
		}
		that.tree(elem);
		that.on(elem);
	};

	// 树节点解析
	Tree.prototype.tree = function(elem, children) {
		var that = this, options = that.options
		var nodes = children || options.nodes;

		layui.each(nodes, function(index, item) {
			var hasChild = item.children && item.children.length > 0;
			var ul = $('<ul class="' + (item.spread ? "layui-show" : "")
					+ '"></ul>');
			var li = $([
					'<li '+ (item.spread ? 'data-spread="' + item.spread + '"' : '') + '>'
					// 展开箭头
					, function() {
						return hasChild? '<i class="layui-icon layui-tree-spread">'
										+ (item.spread
												? icon.arrow[1]
												: icon.arrow[0]) + '</i>'
								: '';
					}()
					// 复选框/单选框
					, function() {
						return options.check
								? ('<i class="layui-icon layui-tree-check"  layui-check="'
										+ (item.checked ? 'true' : 'fasle')+ '" lay-id="' + item.id + '">'
										+ (options.check === 'checkbox'? (item.checked ? icon.checkbox[1]:icon.checkbox[0]): 
												(options.check === 'radio'? (item.checked ? icon.radio[1]:icon.radio[0]): '')) + '</i>'): '';
					}()

					// 节点
					, function() {
						return '<a href="'
								+ (item.href || 'javascript:;')
								+ '" '
								+ (options.target && item.href ? 'target=\"'
										+ options.target + '\"' : '')
								+ '>'
								+ ('<i class="layui-icon layui-tree-'
										+ (hasChild ? "branch" : "leaf")
										+ '">'
										+ (hasChild ? (item.spread
												? icon.branch[1]
												: icon.branch[0]) : icon.leaf) + '</i>') // 节点图标
								+ ('<cite>' + (item.name || '未命名') + '</cite></a>');
					}()

					, '</li>'].join(''));

			// 如果有子节点，则递归继续生成树
			if (hasChild) {
				li.append(ul);
				that.tree(ul, item.children);
			}

			elem.append(li);

			// 触发点击节点回调
			typeof options.click === 'function' && that.click(li, item);
			// 触发点击多选框回调
			typeof options.checkedClick === 'function'&& that.checkedClick(li, item);

			// 伸展节点
			that.spread(li, item);

			// 拖拽节点
			options.drag && that.drag(li, item);
		});
	};

	// 点击节点回调
	Tree.prototype.click = function(elem, item) {
		var that = this, options = that.options;
		elem.children('a').on('click', function(e) {
					layui.stope(e);
					options.click(item);
				});
	};

	// 点击多选框
	Tree.prototype.checkedClick = function(elem, item) {
		var ids = '';
		var that = this, options = that.options;
		var lay = $(".layui-tree").find('.layui-tree-check[layui-check=true]');
		layui.each(lay, function(i, v) {
					var lay_id = $(v).attr('lay-id');
					ids += lay_id + ',';
				});
		if (ids != '') {
			ids = ids.substr(0, ids.length - 1)
		}
		$(".layui-tree").data('treeChecked', ids);

		elem.children(".layui-tree-check").on("click", function(e) {
			var checkbox = this;
			if (options.check == 'checkbox') {
				var ckecked = (/^true$/i)
						.test(checkbox.attributes["layui-check"].value);
				that.currentNode(checkbox, !ckecked);
				that.childrenNode(checkbox, !ckecked);
			}
			var ids = '';
			var rootNode = $(e.currentTarget).parents().find('.layui-tree');
			var lay = rootNode.find('.layui-tree-check[layui-check=true]');
			layui.each(lay, function(i, v) {
						var lay_id = $(v).attr('lay-id');
						ids += lay_id + ',';
					});
			if (ids != '') {
				ids = ids.substr(0, ids.length - 1)
			}
			rootNode.data('treeChecked', ids);

			if ("function" == typeof options.checkedClick) {
				layui.stope(e);
				options.checkedClick(ids);
			}
		})
	};

	// 获取当前节点
	Tree.prototype.currentNode = function(element, ck) {
		var a = this;
		var siblingsNode = $(element).parent().siblings()
				.children('.layui-tree-check[layui-check=' + ck + ']');
		var prtNode = $(element).parent().parent().children();
		// var childNode = o(element).siblings('ul').children('li');
		$(element).attr("layui-check", ck);
		var s = ck == true ? 1 : 0;
		$(element).html(icon.checkbox[s]);
		// a.childrenNode(childNode,ck);
		if (ck) {
			if (siblingsNode.length == 0) {
				a.parentNode(element, ck);
			}
		} else {
			if (siblingsNode.length == prtNode.length - 1) {
				a.parentNode(element, ck);
			}
		}
	};

	// 获取父节点
	Tree.prototype.parentNode = function(element, ck) {
		var a = this;
		var prtNode = $(element).parent().parent().parent()
				.children('.layui-tree-check');
		if (prtNode.length > 0) {
			a.currentNode(prtNode, ck);
		}
	},

	// 获取子节点
	Tree.prototype.childrenNode = function(element, ck) {
		var a = this;
		var cldNode = $(element).siblings('ul').children('li')
				.children('.layui-tree-check');
		if (cldNode.length > 0) {
			cldNode.attr("layui-check", ck);
			var s = ck == true ? 1 : 0;
			cldNode.html(icon.checkbox[s]);
			a.childrenNode(cldNode, ck)
		}
	},

	// 伸展节点
	Tree.prototype.spread = function(elem, item) {
		var that = this, options = that.options;
		var arrow = elem.children('.layui-tree-spread')
		var ul = elem.children('ul'), a = elem.children('a');

		// 执行伸展
		var open = function() {
			if (elem.data('spread')) {
				elem.data('spread', null)
				ul.removeClass('layui-show');
				arrow.html(icon.arrow[0]);
				a.find('.layui-icon').html(icon.branch[0]);
			} else {
				elem.data('spread', true);
				ul.addClass('layui-show');
				arrow.html(icon.arrow[1]);
				a.find('.layui-icon').html(icon.branch[1]);
			}
		};

		// 如果没有子节点，则不执行
		if (!ul[0])
			return;

		arrow.on('click', open);
		a.on('dblclick', open);
	}

	// 通用事件
	Tree.prototype.on = function(elem) {
		var that = this, options = that.options;
		var dragStr = 'layui-tree-drag';

		// 屏蔽选中文字
		elem.find('i').on('selectstart', function(e) {
					return false
				});

		// 拖拽
		if (options.drag) {
			$(document).on('mousemove', function(e) {
				var move = that.move;
				if (move.from) {
					var to = move.to, treeMove = $('<div class="layui-box '
							+ dragStr + '"></div>');
					e.preventDefault();
					$('.' + dragStr)[0] || $('body').append(treeMove);
					var dragElem = $('.' + dragStr)[0]
							? $('.' + dragStr)
							: treeMove;
					(dragElem).addClass('layui-show').html(move.from.elem
							.children('a').html());
					dragElem.css({
								left : e.pageX + 10,
								top : e.pageY + 10
							})
				}
			}).on('mouseup', function() {
				var move = that.move;
				if (move.from) {
					move.from.elem.children('a').removeClass(enterSkin);
					move.to
							&& move.to.elem.children('a')
									.removeClass(enterSkin);
					that.move = {};
					$('.' + dragStr).remove();
				}
			});
		}
	};

	// 拖拽节点
	Tree.prototype.move = {};
	Tree.prototype.drag = function(elem, item) {
		var that = this, options = that.options;
		var a = elem.children('a'), mouseenter = function() {
			var othis = $(this), move = that.move;
			if (move.from) {
				move.to = {
					item : item,
					elem : elem
				};
				othis.addClass(enterSkin);
			}
		};
		a.on('mousedown', function() {
					var move = that.move
					move.from = {
						item : item,
						elem : elem
					};
				});
		a.on('mouseenter', mouseenter).on('mousemove', mouseenter).on(
				'mouseleave', function() {
					var othis = $(this), move = that.move;
					if (move.from) {
						delete move.to;
						othis.removeClass(enterSkin);
					}
				});
	};

	// 暴露接口
	exports('tree', function(options) {
				var tree = new Tree(options = options || {});
				var elem = $(options.elem);
				if (!elem[0]) {
					return hint.error('layui.tree 没有找到' + options.elem + '元素');
				}
				tree.init(elem);
			});
});
