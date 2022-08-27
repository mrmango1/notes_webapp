const clearDataForm = (form, ...args) => {
  const formData = new FormData(form)
  args.forEach((e) => (!formData.get(e) ? formData.delete(e) : null))
  return formData
}
const checkPassword = (form) => {
  const formData = new FormData(form)
  const password = formData.get("password")
  const confirmPassword = formData.get("confirmPassword")
  if (password !== confirmPassword) {
    console.log(password, confirmPassword)
    return false
  }
  console.log(password, confirmPassword)
  return true
}

function register(event, form) {
  if (!checkPassword(form)) {
    alert("Password and confirm password are not equal")
    event.preventDefault()
    return
  }
  else{
    fetch(form.action, {
      method: "POST",
      body: clearDataForm(form, "confirmPassword", "observation"),
    }).then((response) => {
      if (response.ok) {
        window.location.replace("./index.jsp");
      } else {
        alert("Error: " + response.statusText);
      }
    })
  }
  event.preventDefault()
}