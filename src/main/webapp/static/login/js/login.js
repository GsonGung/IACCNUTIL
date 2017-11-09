//----------------------------------------------------------
// https://passport.isoftstone.com/Login/JS/Index
// 脚本生成时间: 2017/7/23 9:45:53
// Copyright © 2001-2017 软通动力信息技术（集团）有限公司 版权所有
//----------------------------------------------------------
var login = {
    pageload: function () {
    	//$("#loading").hide();
        /*$("#ReturnUrl").val("");
        $("#loading").hide();
        var ctp = $("#ctip").val();
        var etp = $("#etip").val();
        var $DomainName = $("#DomainName input");
        var $Password = $("#Password input");
        var $form = $("#g_loginform form");
        $(".error").removeClass("error");
        if ($("#uname").val() != "") {
            $("#RemeberMe").attr("checked", true);
        }
        if ($("#flag").val() == "0") {
            $("#Special").val(ctp);
            $("#Submit").addClass("error");
        }
        $("#DomainName input").focus();

        $("input").keydown(function (e) {
            var $this = $(this);
            $(".error").removeClass("error");
            if (e.keyCode == 13) {
            	alert($this.attr("name"));
                if ($this.attr("name") == "emp_Password") {
                    $("#BtnLogin").trigger("click");
                }
            }
        });

        $("#bgLogin").click(function (e) {
            $("#ReturnUrl").val("Special");
            $("#BtnLogin").trigger("click");
        });

        $("#Special").click(function (e) {
            $("#ReturnUrl").val("Special");
            $("#BtnLogin").trigger("click");
        });

        $("#BtnQS").click(function (e) {
            $("#ReturnUrl").val("QS");
            $("#BtnLogin").trigger("click");
        });
        $("#BtnHIPO").click(function (e) {
            $("#ReturnUrl").val("HIPO");
            $("#BtnLogin").trigger("click");
        });

        $("#BtnLogin").click(function (e) {
            e.preventDefault();
            var $this = $(this);
            var goHome = true;
            $(".error").removeClass("error");

            if ($DomainName.val().length == 0) {
                $DomainName.parent().addClass("error");
                goHome = false;
            }
            if ($Password.val().length == 0) {
                $Password.parent().addClass("error");
                goHome = false;
            }

            if (goHome) {
            	//alert($DomainName.val());
                e.preventDefault();
                $this.val(etp);
                $("#loading").show();
                //$form.submit();
                login.loginValiDate($DomainName.val(),$Password.val())
                goHome = false;
                $("#loading").hide();
            }
        });

        $("#BtnQ12").click(function (e) {
            $("#ReturnUrl").val("Q12");
            e.preventDefault();
            var $this = $(this);
            var goHome = true;
            $(".error").removeClass("error");

            if ($DomainName.val().length == 0) {
                $DomainName.parent().addClass("error");
                goHome = false;
            }
            if ($Password.val().length == 0) {
                $Password.parent().addClass("error");
                goHome = false;
            }

            if (goHome) {
            	alert(2);
                e.preventDefault();
                $this.val(etp);
                $("#loading").show();
                $form.submit();
                
            }
        });

        $("#BtnLink").click(function (e) {
            $("#ReturnUrl").val("Special");
            e.preventDefault();
            var $this = $(this);
            var goHome = true;
            $(".error").removeClass("error");

            if ($DomainName.val().length == 0) {
                $DomainName.parent().addClass("error");
                goHome = false;
            }
            if ($Password.val().length == 0) {
                $Password.parent().addClass("error");
                goHome = false;
            }

            if (goHome) {
                e.preventDefault();
                $this.val(etp);
                $("#loading").show();
                $form.submit();

            }
        });
        login.initlang();
        var imgarr = $("#bgstr").val().split(",");
        $("#g_loginform").bgswitcher({
            images: imgarr,
            shuffle: false
        });
        $("#bgslideol li").click(function (e) {
            $("#g_loginform").bgswitcher("select", $(this).attr("ajax-id"));
        });*/
    	login.initlang();
    	setTimeout( function(){
    		$("#loading").hide();
    	}, 1 * 1000 );
    	
    },
    /*=================================================================*/
    initlang: function () {
        var _sCurrentLanguage = $("html").attr("lang");
        var _$Language = $("#g_language");
        var _SupportedLanguages = [{ name: "zh-CN", display: "简体中文" }, { name: "en-US", display: "English"}];
        if (_sCurrentLanguage == "") {
            _sCurrentLanguage = "zh-CN";
        }
        _$Language.html("");
        _$Language.append("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" title=\"简体中文\">简体中文<b class=\"caret\"></b></a>");
        _$Language.append("<ul class=\"dropdown-menu\"></ul>");

        var _$Current = _$Language.children("a");
        var _$List = _$Language.children("ul");

        $.each(_SupportedLanguages, function (index, value) {
            if (value.name === _sCurrentLanguage) {

                _$Current.attr("title", value.display).html(value.display + '<b class="caret"></b>');
            }
            else {
                _$List.append("<li><a href=\"#\" title=\"" + value.display + "\" lang=\"" + value.name + "\"><i class=\"icon-flags " + value.name + "\"></i>" + value.display + "</a></li>");
            }
        });

        _$List.find("li a").bind("click", function (e) {
            e.preventDefault();
            login.setlan($(this).attr("lang"));
        });
    },
    setlan: function (lang) {
    	
    	if("zh-CN"==lang){
    		alert("切换为：简体中文");
    	}else if("en-US"==lang){
    		alert("切换为：English");
    	}else{
    		alert("切换错误");
    	}
    	/**
        $.ajax('/Login/lang/' + lang + "?r=" + Math.random(), {
            success: function (e) {
                if (e == "ok") {
                    window.location.href = '/Login/Index/';
                }
            }
        })**/

        return true;
    }
};
/**
 * 用户登录系统验证
 * @returns
 */
function loginValiDate(){
	 //登录名
	 var emp_DomainName = $("#emp_DomainName").val();
	 //登录密码
	 var emp_Password = $("#emp_Password").val();
	 //是否记住密码
	 var remFlag = $("#RemeberMe").is(':checked');
	 $(".error").removeClass("error");
	 //获取文本框对象
     var $DomainName = $("#DomainName input");
     var $Password = $("#Password input");
     if (emp_DomainName=="" && emp_Password == "") {
         $DomainName.parent().addClass("error");
         $Password.parent().addClass("error");
     	 $("#errorId").css("visibility","hidden") 
         $("#errorId").html("");
         return false;
     }
     if (emp_DomainName=="") {
         $DomainName.parent().addClass("error");
     	 $("#errorId").css("visibility","hidden") 
         $("#errorId").html("");
         return false;
     }
     if (emp_Password == "") {
         $Password.parent().addClass("error");
     	 $("#errorId").css("visibility","hidden") 
         $("#errorId").html("");
         return false;
     }
     $("#loading").show();
     //正在登录
     $("#BtnLogin").val($("#etip").val());
     //设置1秒的登录时间，防止频繁刷新请求
     setTimeout( function(){
    	 var url = "loginValidate.do?r=" + Math.random();
    	    $.ajax({
    	        type: "post",
    	        url: url,
    	        data: {"emp_DomainName":emp_DomainName,"emp_Password":emp_Password,"remFlag":remFlag},
    	        cache: false,
    	        async : false,
    	        dataType: "json",
    	        success: function (data ,textStatus, jqXHR)
    	        {
    	        	setTimeout( function(){
    	        		
    	        		$("#loading").hide();
        	            if("0000"==data){
        	            	//跳转到主页面
        	            	window.location.href="../home/toHome.do";
        	            	
        	            }else if("0001"==data){
        	            	
        	            	$("#errorId").css("visibility","visible") 
        	                $("#errorId").html("用户名或密码错误，请重新登录！");
        	                $("#BtnLogin").css("color","white");
        	                $("#BtnLogin").val($("#ctip").val());
        	                
        	            }else if("0003"==data){
        	            	
        	                alert("登录失败，系统异常");
        	            }else{
        	            	alert("登录失败，系统异常");
        	            }
    	        	}, 1 * 1000 );
    	        },
    	        error:function (XMLHttpRequest, textStatus, errorThrown) {      
    	            alert("请求失败！");
    	        }
    	     });
 	}, 1 * 1000 );
    
}