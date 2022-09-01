let idToDelete = 0
let idToupdate = 0
let $table = $('#table')

function operateFormatter(value, row, index) {
  return `<button type='button'
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#updateModal'
            onclick="getUpdateData(this)">
            <i class="fa fa-edit"></i> Modificar
    </button>
    <button 
            type='button' 
            class='btn btn-danger actionBtn'
            data-bs-toggle="modal" 
            data-bs-target="#deleteDialog"
            onclick="deleteButton(this)">
            <i class="fa fa-trash"></i> Eliminar
    </button>`
}

function operateFormatterTopic(value, row, index) {
  return `<button type='button'
            style="width: 90px;margin-bottom: 0.3em;"
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#updateModal'
            onclick="getUpdateData(this)">
            <i class="fa fa-edit"></i> Modificar
    </button>
    <button 
            type='button' 
            style="width: 90px"
            class='btn btn-danger actionBtn'
            data-bs-toggle="modal" 
            data-bs-target="#deleteDialog"
            onclick="deleteButton(this)">
            <i class="fa fa-trash"></i> Eliminar
    </button>`
}

const getUpdateData = (element) => {
  let updateData =
    element.parentElement.parentElement.getElementsByTagName("td")
  idToupdate = element.parentElement.parentElement.getAttribute("data-uniqueid")
  let uForm = document
    .getElementById("updateForm")
    .getElementsByClassName("update-control")
  uForm[0].value = updateData[0].innerHTML
  uForm[1].value = updateData[1].innerHTML
  uForm[2].value = updateData[2].innerHTML
  uForm[3].valueAsDate = new Date(updateData[3].innerHTML)
  updateData[4].getElementsByTagName("input")[0].checked ? uForm[4].checked = true : uForm[4].checked = false
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
