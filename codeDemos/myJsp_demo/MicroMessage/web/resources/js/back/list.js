/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath){
    //临时用 id 修改提交的 form action,将其提交到 web.xml 配置的 deleteBatch 的 url 上
    $("#mainForm").attr("action",basePath + "/DeleteBatchServlet.action");
    $("#mainForm").submit();
}