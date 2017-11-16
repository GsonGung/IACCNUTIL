<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String resources = basePath + "resources/";
    String plugins = resources + "plugins/";
%>
<!-- Ion Slider -->
<link rel="stylesheet" href="<%=plugins%>ionslider/ion.rangeSlider.css">
<!-- ion slider Nice -->
<link rel="stylesheet" href="<%=plugins%>ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet" href="<%=plugins%>bootstrap-slider/slider.css">
<!-- Main content -->
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">Ion Slider</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="row margin">
                        <div class="col-sm-6">
                            <input id="range_1" type="text" name="range_1">
                        </div>

                        <div class="col-sm-6">
                            <input id="range_2" type="text" name="range_2">
                        </div>
                    </div>
                    <div class="row margin">
                        <div class="col-sm-6">
                            <input id="range_5" type="text" name="range_5">
                        </div>
                        <div class="col-sm-6">
                            <input id="range_6" type="text" name="range_6">
                        </div>
                    </div>
                    <div class="row margin">
                        <div class="col-sm-12">
                            <input id="range_4" type="text" name="range_4">
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">Bootstrap Slider</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="row margin">
                        <div class="col-sm-6">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="red">

                            <p>data-slider-id="red"</p>
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="blue">

                            <p>data-slider-id="blue"</p>
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="green">

                            <p>data-slider-id="green"</p>
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="yellow">

                            <p>data-slider-id="yellow"</p>
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="aqua">

                            <p>data-slider-id="aqua"</p>
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="horizontal" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="purple">

                            <p style="margin-top: 10px">data-slider-id="purple"</p>
                        </div>
                        <div class="col-sm-6 text-center">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="red">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="blue">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="green">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="yellow">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="aqua">
                            <input type="text" value="" class="slider form-control" data-slider-min="-200"
                                   data-slider-max="200" data-slider-step="5" data-slider-value="[-100,100]"
                                   data-slider-orientation="vertical" data-slider-selection="before"
                                   data-slider-tooltip="show" data-slider-id="purple">
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
<!-- Ion Slider -->
<script src="<%=plugins%>ionslider/ion.rangeSlider.min.js"></script>
<!-- Bootstrap slider -->
<script src="<%=plugins%>bootstrap-slider/bootstrap-slider.js"></script>
<script>
    $(function () {
        /* BOOTSTRAP SLIDER */
        $('.slider').bootstrapSlider({
            tooltip: 'always'
        });

        /* ION SLIDER */
        $("#range_1").ionRangeSlider({
            min: 0,
            max: 5000,
            from: 1000,
            to: 4000,
            type: 'double',
            step: 1,
            prefix: "$",
            prettify: false,
            hasGrid: true
        });
        $("#range_2").ionRangeSlider({
//            type: 'single'
        });

        $("#range_5").ionRangeSlider({
            min: 0,
            max: 10,
            type: 'single',
            step: 0.1,
            postfix: " mm",
            prettify: false,
            hasGrid: true
        });
        $("#range_6").ionRangeSlider({
            min: -50,
            max: 50,
            from: 0,
            type: 'single',
            step: 1,
            postfix: "°",
            prettify: false,
            hasGrid: true
        });

        $("#range_4").ionRangeSlider({
            type: "single",
            step: 10,
            postfix: " light years",
            from: 100,
            to: 500,
            hideMinMax: true,
            hideFromTo: false,
            hasGrid: true
        });
    });
</script>
