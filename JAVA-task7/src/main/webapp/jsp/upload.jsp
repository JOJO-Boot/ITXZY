<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
</head>
<body>
<input type="file"  accept="images/*"  id="upload" name="file">

<script>
    $("#upload").live("change",upload);
    function upload(event){
        alert("图片读取较慢，请等待十秒左右");
        if(event.target.files.length == 1 ) {
            if (event.target.files[0].size >= 4096000) {
                alert('您这张图片过大，应小于4M');
            }else{
                $.ajaxFileUpload({url:'photoupload',
                    secureuri:false,
                    fileElementId:'upload',
                    dataType: 'text/html',
                    success: function(data,success){
                        alert(data);
                    },
                    error: function (data, status, e){
                        alert("上传图片失败，请稍后重试。");
                        closeLoad();
                    }
                });
            }
        }else{
            alert('您上传的不是图片，请选择图片上传');
        }
    }
</script>
</body>
</html>
