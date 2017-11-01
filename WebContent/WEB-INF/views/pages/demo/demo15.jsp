<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<link rel="stylesheet" href="<%=plugins%>SmartWizard/css/smart_wizard.css">
<link rel="stylesheet" href="<%=plugins%>SmartWizard/css/smart_wizard_theme_arrows.css">
<div id="smartwizard" class="sw-main">
    <ul class="nav nav-tabs step-anchor">
        <li class="done"><a href="#step-1">基本信息<br>

        </a></li>
        <li class="active"><a href="#step-2">本司情况<br>

        </a></li>
        <li class="done"><a href="#step-3">联系方式<br>

        </a></li>
        <li class="done"><a href="#step-4">家庭成员<br>

        </a></li>
        <li class="done"><a href="#step-1">紧急联系人<br>

        </a></li>
        <li class="done"><a href="#step-2">教育经历<br>

        </a></li>
        <li class="done"><a href="#step-3">工作经历<br>

        </a></li>
        <li class="done"><a href="#step-4">项目经历<br>

        </a></li>
        <li class="done"><a href="#step-4">语言技能<br>

        </a></li>
        <li class="done"><a href="#step-4">所获证书<br>

        </a></li>
        <li class="done"><a href="#step-4">培训信息<br>

        </a></li>
        <li class="done"><a href="#step-4">宿舍分配<br>

        </a></li>
        <li class="done"><a href="#step-4">附加信息<br>

        </a></li>
        <li class="done"><a href="#step-4">持卡情况<br>

        </a></li>
        <li class="done"><a href="#step-4">工作安排<br>

        </a></li><li class="done"><a href="#step-4">物资领用<br>

    </a></li>
        <li class="done"><a href="#step-4">健康状态<br>

        </a></li>
        <li class="done"><a href="#step-4">福利状况<br>

        </a></li>
    </ul>
    <div class="sw-container tab-content" style="height: 219px;">
        <div id="step-1" class="step-content" style="">
            <h2>Step 1 Content</h2>
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
        </div>
        <div id="step-2" class="step-content" style="">
            <h2>Step 2 Content</h2>
            <div>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
                industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
                scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap
                into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the
                release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing
                software like Aldus PageMaker including versions of Lorem Ipsum.
            </div>
        </div>
        <div id="step-3" class="step-content" style="">
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
            scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
            electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.
        </div>
        <div id="step-4" class="step-content" style="">
            <h2>Step 4 Content</h2>
            <div class="panel panel-default">
                <div class="panel-heading">My Details</div>
                <table class="table">
                    <tbody>
                    <tr>
                        <th>Name:</th>
                        <td>Tim Smith</td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>example@example.com</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#smartwizard').smartWizard({theme: 'arrows'});
    });
</script>