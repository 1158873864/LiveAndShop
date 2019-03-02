<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      你成功了！小伙子
  ${city}
    <form action="UserManage/AddUser" method="post"> 
      <input type="text" name="Userid" />
        <input type="text" name="Username" />
          <input type="text" name="Usersex" />
            <input type="text" name="Photonumble" />
            <input type="text" name="Signature" />
            <input type="submit" value="提交"/>
       
    </form>
  
  
</body>
</html>