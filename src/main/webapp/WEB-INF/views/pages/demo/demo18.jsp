<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<link rel="stylesheet" type="text/css" href="<%=plugins%>loaders.css/loaders.css"/>
<style>
    div.loaders {
        animation: opacityIn 1s ease-in;
        background: #ed5565;
        color: #fff;
        width: 100%;
        box-sizing: border-box;
        display: -ms-flexbox;
        display: flex;
        -ms-flex: 0 1 auto;
        flex: 0 1 auto;
        -ms-flex-direction: row;
        flex-direction: row;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
    }

    div.loader {
        box-sizing: border-box;
        display: -ms-flexbox;
        display: flex;
        -ms-flex: 0 1 auto;
        flex: 0 1 auto;
        -ms-flex-direction: column;
        flex-direction: column;
        -ms-flex-positive: 1;
        flex-grow: 1;
        -ms-flex-negative: 0;
        flex-shrink: 0;
        -ms-flex-preferred-size: 25%;
        flex-basis: 25%;
        max-width: 25%;
        height: 200px;
        -ms-flex-align: center;
        align-items: center;
        -ms-flex-pack: center;
        justify-content: center;
    }
</style>
<div class="-main">
    <div class="-header">
        <div class="left">
            <h1>Loaders<span>.css</span></h1>
            <h2>Delightful and performance-focused pure css loading animations.</h2>
        </div>
        <div class="right"><a href="https://github.com/ConnorAtherton/loaders.css" class="btn right">View on Github</a>
        </div>
    </div>
    <div class="loaders">
        <div class="loader">
            <div class="loader-inner ball-pulse">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-grid-pulse">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-clip-rotate">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-clip-rotate-pulse">
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner square-spin">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-clip-rotate-multiple">
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-pulse-rise">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-rotate">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner cube-transition">
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-zig-zag">
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-zig-zag-deflect">
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-triangle-path">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-scale">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner line-scale">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner line-scale-party">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-scale-multiple">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-pulse-sync">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-beat">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner line-scale-pulse-out">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner line-scale-pulse-out-rapid">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-scale-ripple">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-scale-ripple-multiple">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-spin-fade-loader">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner line-spin-fade-loader">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner triangle-skew-spin">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner pacman">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner semi-circle-spin">
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-grid-beat">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
        <div class="loader">
            <div class="loader-inner ball-scale-random">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        document.querySelector('main').className += 'loaded';
    });
</script>