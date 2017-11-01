<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<link rel="stylesheet" type="text/css" href="<%=plugins%>load-awesome/docs/assets/loaders.css"/>
<style>
    main .items {
        display: block;
        width: 100%;
        position: relative;
    }
    main .items:after {
        display: table;
        float: none;
        clear: both;
        content: "";
    }
    main .items .item {
        position: relative;
        width: 25%;
        height: 180px;
        text-align: center;
        float: left;
        -webkit-transition: all 250ms linear;
        -moz-transition: all 250ms linear;
        -o-transition: all 250ms linear;
        transition: all 250ms linear;
    }
    main .items .item .item-inner {
        position: relative;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        width: 100%;
        height: 100%;
        -ms-flex-pack: center;
        -ms-flex-align: center;
        -webkit-box-pack: center;
        -webkit-justify-content: center;
        -moz-box-pack: center;
        justify-content: center;
        -webkit-box-align: center;
        -webkit-align-items: center;
        -moz-box-align: center;
        align-items: center;
    }
    main .auto-height .item {
        height: auto;
    }
    main .auto-height:not(.title) .item {
        padding: 45px 0 50px;
    }
    main .showroom .item {
        width: 29.333333%;
    }
    main .showroom .item:first-child {
        width: 12%;
        text-align: left;
        position: initial;
    }
    main .showroom .item:first-child h3 {
        position: absolute;
        top: 50%;
        left: 0;
        margin: 0;
        line-height: .8em;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
    }
    main .items .fix-position > div {
        position: relative;
        left: 50%;
        -webkit-transform: translateX(-50%);
        -moz-transform: translateX(-50%);
        -ms-transform: translateX(-50%);
        -o-transform: translateX(-50%);
        transform: translateX(-50%);
    }
    main .items-list .item .item-loader-container div, main .items-list .item .item-loader-container div:before, main .items-list .item .item-loader-container div:after {
        -webkit-animation-play-state: paused;
        -moz-animation-play-state: paused;
        -o-animation-play-state: paused;
        animation-play-state: paused;
    }
    main .items-list .item:hover .item-loader-container div, main .items-list .item:hover .item-loader-container div:before, main .items-list .item:hover .item-loader-container div:after {
        -webkit-animation-play-state: running;
        -moz-animation-play-state: running;
        -o-animation-play-state: running;
        animation-play-state: running;
    }
    main .items .item .item-ribbon-wrapper {
        position: absolute;
        top: 15px;
        left: 15px;
        width: 55px;
        height: 55px;
        overflow: hidden;
    }
    main .items .item .item-ribbon-wrapper .item-ribbon {
        position: relative;
        top: 10px;
        left: -40px;
        width: 120px;
        padding: 2px 0 4px;
        font-size: 12px;
        line-height: 1em;
        color: #fff;
        text-align: center;
        background-color: #ff6f6f;
        -webkit-transform: rotate(-45deg);
        -moz-transform: rotate(-45deg);
        -ms-transform: rotate(-45deg);
        -o-transform: rotate(-45deg);
    }
    main .items .item .item-title {
        position: absolute;
        right: 0;
        bottom: 0;
        left: 0;
        font-size: 12px;
        line-height: 1em;
        text-align: center;
    }
    main .items .item .item-title a, main .items .item .item-title button {
        position: relative;
        display: block;
        width: 100%;
        padding: 10px 0;
        color: rgba(255, 255, 255, .7);
        text-decoration: none;
        cursor: pointer;
        background: transparent;
        border: none;
        -webkit-transition: color 200ms ease;
        -moz-transition: color 200ms ease;
        -o-transition: color 200ms ease;
        transition: color 200ms ease;
    }
    main .items .item .item-title a:hover, main .items .item .item-title button:hover {
        color: #fff;
    }
    main .items .item.bg-light .item-title a, main .items .item.bg-light .item-title button {
        color: #777;
    }
    main .items .item.bg-light .item-title a:hover, main .items .item.bg-light .item-title button:hover {
        color: #333;
    }
    .bg-light main .items .item .item-title a, .bg-light main .items .item .item-title button, body[data-items-color="dark"] main .items .item .item-title a, body[data-items-color="custom"] main .items .item .item-title a {
        color: rgba(56, 162, 75, .8);
    }
    .bg-light main .items .item .item-title a:hover, .bg-light main .items .item .item-title button:hover, body[data-items-color="dark"] main .items .item .item-title a:hover, body[data-items-color="custom"] main .items .item .item-title a:hover {
        color: rgba(56, 162, 75, 1);
    }
    main .items .item .item-title a span {
        position: absolute;
        top: 10px;
        opacity: 0;
        -webkit-transition: all 150ms ease;
        -moz-transition: all 150ms ease;
        -o-transition: all 150ms ease;
        transition: all 150ms ease;
        -webkit-transform: translateX(-10px);
        -moz-transform: translateX(-10px);
        -ms-transform: translateX(-10px);
        -o-transform: translateX(-10px);
        transform: translateX(-10px);
    }
    main .items .item .item-title a:hover span {
        opacity: 1;
        -webkit-transform: translateX(5px);
        -moz-transform: translateX(5px);
        -ms-transform: translateX(5px);
        -o-transform: translateX(5px);
        transform: translateX(5px);
    }
    .la-docs-footer {
        padding-top: 0;
        padding-bottom: 10px;
        margin: 4em auto 0;
        font-size: .85em;
        text-align: center;
    }
    .la-docs-footer p, .la-docs-footer ul {
        margin: 10px 0;
    }
    .la-docs-footer-links li {
        display: inline;
        padding: 0 2px;
        color: #fff;
    }
</style>
<div class="wrapper nano" style="background-color: #98bff6; color: #98bff6;">
    <div class="nano-content">
        <main>
            <div class="items-list-helper">
                <span style="background-color: #98bff6;"><i class="fa fa-info-circle"></i> Move your mouse over each animation to play</span>
            </div>
            <div class="items items-list">
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-8bits la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-8bits.html">Ball 8bits<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-atom la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-atom.html">Ball Atom<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-beat la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-beat.html">Ball Beat<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-circus la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-circus.html">Ball Circus<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-climbing-dot la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-climbing-dot.html">Ball Climbing
                        Dot<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-clip-rotate la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-clip-rotate.html">Ball Clip
                        Rotate<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-clip-rotate-multiple la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-clip-rotate-multiple.html">Ball Clip Rotate
                        Multiple<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-clip-rotate-pulse la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-clip-rotate-pulse.html">Ball Clip Rotate
                        Pulse<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-elastic-dots la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-elastic-dots.html">Ball Elastic
                        Dots<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-fall la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-fall.html">Ball Fall<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-fussion la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-fussion.html">Ball Fussion<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-grid-beat la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-grid-beat.html">Ball Grid Beat<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-grid-pulse la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-grid-pulse.html">Ball Grid
                        Pulse<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-newton-cradle la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-newton-cradle.html">Ball Newton
                        Cradle<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-pulse la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-pulse.html">Ball Pulse<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-pulse-rise la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-pulse-rise.html">Ball Pulse
                        Rise<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-pulse-sync la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-pulse-sync.html">Ball Pulse
                        Sync<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-rotate la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-rotate.html">Ball Rotate<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-running-dots la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-running-dots.html">Ball Running
                        Dots<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-scale la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-scale.html">Ball Scale<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-scale-multiple la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-scale-multiple.html">Ball Scale Multiple<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-scale-pulse la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-scale-pulse.html">Ball Scale
                        Pulse<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-scale-ripple la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-scale-ripple.html">Ball Scale
                        Ripple<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-scale-ripple-multiple la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-scale-ripple-multiple.html">Ball Scale Ripple
                        Multiple<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin.html">Ball Spin<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-clockwise la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-clockwise.html">Ball Spin Clockwise<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-clockwise-fade la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-clockwise-fade.html">Ball Spin Clockwise
                        Fade<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-clockwise-fade-rotating la-2x">
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
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-clockwise-fade-rotating.html">Ball Spin
                        Clockwise Fade Rotating<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-fade la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-fade.html">Ball Spin Fade<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-fade-rotating la-2x">
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
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-fade-rotating.html">Ball Spin Fade
                        Rotating<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-spin-rotate la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-spin-rotate.html">Ball Spin
                        Rotate<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-square-clockwise-spin la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-square-clockwise-spin.html">Ball Square Clockwise
                        Spin<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-square-spin la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-square-spin.html">Ball Square
                        Spin<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-triangle-path la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-triangle-path.html">Ball Triangle
                        Path<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-zig-zag la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-zig-zag.html">Ball Zig Zag<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-ball-zig-zag-deflect la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/ball-zig-zag-deflect.html">Ball Zig Zag Deflect<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-cog la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/cog.html">Cog<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-cube-transition la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/cube-transition.html">Cube
                        Transition<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-fire la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/fire.html">Fire<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-scale la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-scale.html">Line Scale<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-scale-party la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-scale-party.html">Line Scale
                        Party<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-scale-pulse-out la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-scale-pulse-out.html">Line Scale Pulse Out<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-scale-pulse-out-rapid la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-scale-pulse-out-rapid.html">Line Scale Pulse Out
                        Rapid<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-spin-clockwise-fade la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-spin-clockwise-fade.html">Line Spin Clockwise
                        Fade<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-spin-clockwise-fade-rotating la-2x">
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
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-spin-clockwise-fade-rotating.html">Line Spin
                        Clockwise Fade Rotating<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-spin-fade la-2x">
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
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-spin-fade.html">Line Spin Fade<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-line-spin-fade-rotating la-2x">
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
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/line-spin-fade-rotating.html">Line Spin Fade
                        Rotating<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-pacman la-2x">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/pacman.html">Pacman<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-square-jelly-box la-2x">
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/square-jelly-box.html">Square Jelly
                        Box<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-square-loader la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/square-loader.html">Square
                        Loader<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-square-spin la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/square-spin.html">Square Spin<span>&#8594;</span></a>
                    </div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-timer la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-ribbon-wrapper">
                        <div class="item-ribbon">NEW</div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/timer.html">Timer<span>&#8594;</span></a></div>
                </div>
                <div class="item">
                    <div class="item-inner">
                        <div class="item-loader-container">
                            <div class="la-triangle-skew-spin la-2x">
                                <div></div>
                            </div>
                        </div>
                    </div>
                    <div class="item-title"><a href="<%=plugins%>load-awesome/docs/animations/triangle-skew-spin.html">Triangle Skew
                        Spin<span>&#8594;</span></a></div>
                </div>
            </div>
        </main>
    </div>
    <main class="la-docs-footer">
        <footer>
            <ul class="la-docs-footer-links">
                <li>
                    Load Awesome 1.1.0
                </li>
                <li>·</li>
                <li>Created by <a href="https://twitter.com/DanielCardoso" target="_blank">@DanielCardoso</a></li>
                <li>·</li>
                <li>Licensed under
                    <a rel="license" href="https://github.com/danielcardoso/load-awesome/blob/master/LICENSE" target="_blank">
                        MIT
                    </a>
                </li>
            </ul>
            <ul class="la-docs-footer-links">
                <li><a href="https://github.com/danielcardoso/load-awesome" target="_blank">GitHub Project</a></li>
                <li>·</li>
                <li><a href="https://github.com/danielcardoso/load-awesome/blob/master/CHANGELOG" target="_blank">Changelog</a></li>
                <li>·</li>
                <li><a href="https://github.com/danielcardoso/load-awesome/issues" target="_blank">Issues</a></li>
                <li>·</li>
                <li><a href="https://github.com/danielcardoso/load-awesome/releases" target="_blank">Releases</a></li>
            </ul>
        </footer>
    </main>
</div>
<script src="<%=plugins%>load-awesome/docs/assets/plugins.min.js"></script>
<script src="<%=plugins%>load-awesome/docs/assets/script.min.js"></script>