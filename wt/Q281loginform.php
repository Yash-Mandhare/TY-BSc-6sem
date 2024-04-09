<!-- Write a PHP script using AJAX concept, to check user name and password are valid or Invalid (usedatabase to store user name and password). -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<h2>Login</h2>
<form id="loginForm" action="#" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>
  
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  
  <input type="submit" value="Login">
</form>

<div id="response"></div>

<script>
$(document).ready(function(){
  $('#loginForm').submit(function(event){
    event.preventDefault();
    var formData = $(this).serialize();
    $.ajax({
      url: 'Q281check_login.php',
      type: 'POST',
      data: formData,
      success: function(response){
        $('#response').html(response);
      }
    });
  });
});
</script>

</body>
</html>
