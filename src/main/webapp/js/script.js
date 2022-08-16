let idToDelete = 0

function operateFormatter(value, row, index) {
  return `<button type='button'
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#updateModal'
            onclick="getUpdateData(this)">
            Modificar
    </button>
    <button 
            type='button' 
            class='btn btn-danger actionBtn'
             data-bs-toggle="modal" 
             data-bs-target="#deleteDialog"
            onclick="deleteButton(this)">
            Eliminar
    </button>`
}

const getUpdateData = (element) => {
  let updateData =
    element.parentElement.parentElement.getElementsByTagName("td")
  let uForm = document
    .getElementById("updateForm")
    .getElementsByClassName("form-control")
  for (let i = 0; i < updateData.length - 1; i++) {
    uForm[i].value = updateData[i].innerHTML
  }
}
const successToast = () => {
  let toastLiveExample = document.getElementById("successToast")
  new bootstrap.Toast(toastLiveExample).show()
  $("#table").bootstrapTable("refresh")
  $(".modal").modal("hide")
}

const errorToast = () => {
  let toastLiveExample = document.getElementById("errorToast")
  let toast = new bootstrap.Toast(toastLiveExample)
  toast.show()
}

const clearDataForm = (form, ...args) => {
  const formData = new FormData(form)
  args.forEach((e) => (!formData.get(e) ? formData.delete(e) : null))
  return formData
}

function doPost(event, form) {
  fetch(form.action, {
    method: "POST",
    body: clearDataForm(form, "finishDate", "observation"),
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
  event.preventDefault()
}
function doPut(event, form) {
  fetch(form.action, {
    method: "PUT",
    body: new FormData(form),
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
  event.preventDefault()
}

function doDelete(id) {
  fetch(`./control?id=${id}`, {
    method: "DELETE",
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
}

function deleteButton(element) {
  idToDelete = element.parentElement.parentElement.querySelector("td").innerHTML
}
