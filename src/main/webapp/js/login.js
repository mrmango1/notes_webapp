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

const login = (event, form) => {
  fetch(form.action, {
    method: "POST",
    body: new FormData(form),
  }).then((response) => {
    if (response.ok) {
      window.location.assign("./index.jsp")
    } else {
      alert("Error: Correo o contraseña incorrectos")
    }
  })
  event.preventDefault()
}

const register = (event, form) => {
  if (!checkPassword(form)) {
    alert("Password and confirm password are not equal")
    event.preventDefault()
    return
  } else {
    fetch(form.action, {
      method: "POST",
      body: clearDataForm(form, "confirmPassword", "observation"),
    }).then((response) => {
      if (response.ok) {
        window.location.assign("./login")
      } else {
        alert("Error: Correo ya registrado")
      }
    })
  }
  event.preventDefault()
}
