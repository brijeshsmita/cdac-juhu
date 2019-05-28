<%@page isELIgnored="false" %>
<html>
<body>

<h2>${msg}</h2>
<hr>
<h3> Welcome ,${userRegister.name } </h3>
<hr>
username :${userRegister.username}
<hr>
address: ${userRegister.address}<hr>
country:${userRegister.country}<hr>
zip: ${userRegister.zip}<hr>
email :${userRegister.email}<hr>
gender:${userRegister.gender}<hr>
english:${userRegister.english}<hr>
nonenglish:${userRegister.nonenglish}<hr>
description:${userRegister.description}
<hr>
<a href="index">Home</a>
</body>
</html>
