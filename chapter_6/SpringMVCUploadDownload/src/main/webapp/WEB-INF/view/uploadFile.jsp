<%--
  Created by IntelliJ IDEA.
  User: yufeng
  Date: 2023/6/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
<h2>文件上传</h2>
  <form action="upload" enctype="multipart/form-data" method="post">
    <table>
      <tr>
        <td>商品ID:</td>
        <td><input type="text" name="productId"></td>
      </tr>
      <tr>
        <td>文件描述:</td>
        <td><input type="text" name="description"></td>
      </tr>
      <tr>
        <td>请选择文件:</td>
        <td><input type="file" name="file"></td>
      </tr>
      <tr>
        <td><input type="submit" value="上传"></td>
      </tr>
    </table>
  </form>
</body>
</html>
