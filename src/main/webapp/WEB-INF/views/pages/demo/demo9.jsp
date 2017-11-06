<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<div class="box box-primary">
    <div class="box-header">
        <i class="fa fa-edit"></i>

        <h3 class="box-title">Simplest</h3>
    </div>
    <div class="box-body pad table-responsive">
        <button class="btn btn-info -info">Info</button>
        <button class="btn btn-warning -warning">Warning</button>
        <button class="btn btn-success -success">Success</button>
        <button class="btn btn-danger -danger">Danger</button>
    </div>
</div>
<div class="box box-primary">
    <div class="box-header">
        <i class="fa fa-edit"></i>

        <h3 class="box-title">Manipulating </h3>
    </div>
    <div class="box-body pad table-responsive">
        <button class="btn btn-default m-message">Message</button>
        <button class="btn btn-default m-title">Title</button>
        <button class="btn btn-default m-button">Button</button>
        <br>
        <br>
        <button class="btn btn-default m-change-title">Change Title</button>
        <button class="btn btn-default m-change-message">Change Message</button>
        <button class="btn btn-default m-change-button">Change Button</button>
        <button class="btn btn-default m-change-type">Change Type</button>
        <button class="btn btn-default m-change-size">Change Size</button>
        <br><br>
        <button class="btn btn-primary m-content">Rich Content</button>
    </div>
</div>

<div class="hide">
    <form class="c-form">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">File input</label>
            <input type="file" id="exampleInputFile">
            <p class="help-block">Example block-level help text here.</p>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Check me out
            </label>
        </div>
        <%--<button type="submit" class="btn btn-default">Submit</button>--%>
    </form>
</div>
<script>
    $('.-info').click(function () {
        BootstrapDialog.alert('I want banana!');
    });
    $('.-warning').click(function () {
        BootstrapDialog.warning('I want banana!');
    });
    $('.-success').click(function () {
        BootstrapDialog.success('I want banana!');
    });
    $('.-danger').click(function () {
        BootstrapDialog.danger('I want banana!');
    });
    $('.m-message').click(function () {
        BootstrapDialog.show({
            message: 'Hi Apple!'
        });
    });
    $('.m-title').click(function () {
        BootstrapDialog.show({
            title: 'Say-hello dialog',
            message: 'Hi Apple!'
        });
    });
    $('.m-button').click(function () {
        BootstrapDialog.show({
            message: 'Hi Apple!',
            buttons: [{
                label: 'Button 1',
                title: 'Mouse over Button 1'
            }, {
                label: 'Button 2',
                // no title as it is optional
                cssClass: 'btn-primary',
                action: function(){
                    alert('Hi Orange!');
                }
            }, {
                icon: 'glyphicon glyphicon-ban-circle',
                label: 'Button 3',
                title: 'Mouse over Button 3',
                cssClass: 'btn-warning'
            }, {
                label: 'Close',
                action: function(dialogItself){
                    dialogItself.close();
                }
            }]
        });
    });
    $('.m-change-message').click(function () {
        BootstrapDialog.show({
            title: 'Default Title',
            message: 'Click buttons below.',
            buttons: [{
                label: 'Message 1',
                action: function (dialog) {
                    dialog.setMessage('Message 1');
                }
            }, {
                label: 'Message 2',
                action: function (dialog) {
                    dialog.setMessage('Message 2');
                }
            }]
        });

    });
    $('.m-change-title').click(function () {
        BootstrapDialog.show({
            title: 'Default Title',
            message: 'Click buttons below.',
            buttons: [{
                label: 'Title 1',
                action: function (dialog) {
                    dialog.setTitle('Title 1');
                }
            }, {
                label: 'Title 2',
                action: function (dialog) {
                    dialog.setTitle('Title 2');
                }
            }]
        });
    });
    $('.m-change-button').click(function () {

        BootstrapDialog.show({
            title: 'Manipulating Buttons',
            message: function(dialog) {
                var $content = $('<div><button class="btn btn-success">Revert button status right now.</button></div>');
                var $footerButton = dialog.getButton('btn-1');
                $content.find('button').click({$footerButton: $footerButton}, function(event) {
                    event.data.$footerButton.enable();
                    event.data.$footerButton.stopSpin();
                    dialog.setClosable(true);
                });

                return $content;
            },
            buttons: [{
                id: 'btn-1',
                label: 'Click to disable and spin.',
                action: function(dialog) {
                    var $button = this; // 'this' here is a jQuery object that wrapping the <button> DOM element.
                    $button.disable();
                    $button.spin();
                    dialog.setClosable(false);
                }
            }]
        });
    });
    $('.m-change-size').click(function () {
        BootstrapDialog.show({
            title: 'More dialog sizes',
            message: 'Hi Apple!',
            buttons: [{
                label: 'Normal',
                action: function(dialog){
                    dialog.setTitle('Normal');
                    dialog.setSize(BootstrapDialog.SIZE_NORMAL);
                }
            }, {
                label: 'Small',
                action: function(dialog){
                    dialog.setTitle('Small');
                    dialog.setSize(BootstrapDialog.SIZE_SMALL);
                }
            }, {
                label: 'Wide',
                action: function(dialog){
                    dialog.setTitle('Wide');
                    dialog.setSize(BootstrapDialog.SIZE_WIDE);
                }
            }, {
                label: 'Large',
                action: function(dialog){
                    dialog.setTitle('Large');
                    dialog.setSize(BootstrapDialog.SIZE_LARGE);
                }
            }]
        });

    });
    $('.m-change-type').click(function () {
        var types = [BootstrapDialog.TYPE_DEFAULT,
            BootstrapDialog.TYPE_INFO,
            BootstrapDialog.TYPE_PRIMARY,
            BootstrapDialog.TYPE_SUCCESS,
            BootstrapDialog.TYPE_WARNING,
            BootstrapDialog.TYPE_DANGER];

        var buttons = [];
        $.each(types, function(index, type) {
            buttons.push({
                label: type,
                cssClass: 'btn-default btn-sm',
                action: function(dialog) {
                    dialog.setType(type);
                }
            });
        });

        BootstrapDialog.show({
            title: 'Changing dialog type',
            message: 'Click buttons below...',
            buttons: buttons
        });
    });


    BootstrapDialog.defaultOptions.autodestroy = false;
    BootstrapDialog.defaultOptions.closeByBackdrop = false; //禁用其他关闭对话框的方式（只通过关闭图标关闭）
    BootstrapDialog.defaultOptions.closeByKeyboard = false;
    BootstrapDialog.DEFAULT_TEXTS['OK'] = '确认';
    BootstrapDialog.DEFAULT_TEXTS['CANCEL'] = '取消';
    BootstrapDialog.DEFAULT_TEXTS['CONFIRM'] = '确认';
    var dialog = new BootstrapDialog({
        title: 'Form',
        message: $('.c-form'),
        buttons: [{
            label: 'OK',
            action: function(dialogRef){
                dialogRef.close();
            }
        }, {
            label: 'Cancel',
            action: function(dialogRef){
                dialogRef.close();
            }
        }]
    });

    $('.m-content').click(function () {
        dialog.open();
    });
</script>