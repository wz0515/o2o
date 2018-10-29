
//初始化函数
$(function () {
    var initUrl = "/o2o/shop/getShopInitInfo";
    var registerShopUrl = "/o2o/shop/registerShop";

    //调用
    getShopInitInfo();

    //获取店铺的基本信息
    function getShopInitInfo() {
        //获取区域分类、店铺分类的数据
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                var tmpHtml = '';
                var tmpAreaHtml = '';
                data.shopCategoryList.map(function (value, index) {
                    tmpHtml += '<option data-id = " ' + value.shopCategoryId + ' " >' + value.shopCategoryName + '</option>';
                });
                data.areaList.map(function (value, index) {
                    tmpAreaHtml += '<option data-id = " ' + value.areaId + ' " >' + value.areaName + '</option>';
                });
                $("#shopCategory").html(tmpHtml);
                $("#area").html(tmpAreaHtml);
            }
        });
        //获取表单数据
        $("#submit").click(function () {
            var shop = {};
            shop.shopName = $("#shopName").value();
            shop.shopCategory = {
                shopCategoryId: $("#shopCategory").find("option").not(function () {
                    return !this.selected;
                }).data("id")
            };
            shop.area = {
                areaId: $("#area").find("option").not(function () {
                    return !this.selected;
                }).data("id")
            };
            shop.shopAddr = $("#shopAddr").value();
            shop.phone = $("#phone").value();
            shop.shopDesc = $("#shopDesc").value();
            //获取图片的文件流
            var shopImg = $("#shopImg")[0].files[0];
            //验证码
            var verifyCodeActual = $("#kaptcha").value();
            if (verifyCodeActual == null) {
                $.toast("请输入验证码");
                return;
            }
            //接收表单数据
            var formData = new formData();
            formData.append("shopImg", shopImg);
            formData.append("shopStr", JSON.stringify(shop));
            formData.append("verifyCodeActual",verifyCodeActual);

            //提交到后台
            $.ajax({
                url : registerShopUrl,
                type : "post",
                data : formData,
                contentType : false,
                processData : false,
                cache : false,
                success : function (data) {    //data是后台返回的信息
                    if (data.success) {
                        $.toast("提交成功");
                    } else {
                        $.toast("提交失败:"+data.errorMsg);
                    }
                }
            });

        });
    }
})