/**
 * Created by Film on 10/11/2559.
 */
function checkPasswordMatch() {
  var password = $("#txtNewPassword").val();
  var confirmPassword = $("#txtConfirmPassword").val();

  if (password != confirmPassword)
    $("#divCheckPasswordMatch").html("Password do not match!");
  else
    $("#divCheckPasswordMatch").html("");
}
