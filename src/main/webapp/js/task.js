let idToDelete = 0
let idToupdate = 0
let $table = $('#table')

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
  idToupdate = element.parentElement.parentElement.getAttribute("data-uniqueid")
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

const addIdTable = (form) => {
  const formData = new FormData(form)
  formData.append("id_task", idToupdate)
  return formData
}

function doPut(event, form) {
  fetch(form.action, {
    method: "PUT",
    body: addIdTable(form),
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
  event.preventDefault()
}

function doDelete() {
  fetch(`./api/task?id_task=${idToDelete}`, {
    method: "DELETE",
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
}

async function getCurrentTable() {
  const response = await fetch("./currentTable")
  const data = await response.json()
  return data
}

async function currentTable() {
  const data = await getCurrentTable()
  document.getElementById("title").innerHTML = data.title
  document.getElementById("description").innerHTML = data.description
}

function deleteButton(element) {
  idToDelete = element.parentElement.parentElement.getAttribute("data-uniqueid")
}

currentTable()
