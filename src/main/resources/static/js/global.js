/*************** 全局js文件,编写一些通用的函数  ***************/
// 统一引入layui自定义模块文件
layui.config({
    version: '1.0.0',
    base: '/js/modules/'
});

// 日期时间格式
const DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

// 像后台发起请求，成功时返回的code值
const REQUEST_SUCCESS_CODE = 0;

/**
 * 获取项目名称
 * @returns string - 项目名称
 */
function getProjectName() {
    // 获取路径
    var pathName = window.document.location.pathname;
    // 截取，得到项目名称
    return pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
}

/**
 * 格式化日期
 * @param timestamp 时间戳【毫秒】
 * @param format 日期格式 yyyy-年 MM-月 dd-日 hh-时 mm-分 ss-秒
 * @returns string类型 - 格式化后的日期字符串
 */
function formatDate(timestamp, format) {
    if (parseInt(timestamp) === timestamp) {
        if (timestamp.length === 10) {
            timestamp = parseInt(timestamp) * 1000;
        } else if (timestamp.length === 13) {
            timestamp = parseInt(timestamp);
        }
    }
    var date = new Date(timestamp);
    var o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds(),                 //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds()             //毫秒
    };

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return format;
}

