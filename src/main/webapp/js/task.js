let idToDelete = 0
let idToupdate = 0
let id_task = 4
let $table = $("#table")

function operateFormatter(value, row, index) {
  return `<button type='button'
          style="width: 90px;"
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#updateModal'
            onclick="getUpdateData(this)">
            <i class="fa fa-edit"></i> Modificar
    </button>
    <button 
            type='button' 
            style="width: 90px;"
            class='btn btn-danger actionBtn'
            data-bs-toggle="modal" 
            data-bs-target="#deleteDialog"
            onclick="deleteButton(this)">
            <i class="fa fa-trash"></i> Eliminar
    </button>`
}

function operateFormatterTopic(value, row, index) {
  return `<button type='button'
            style="width: 60px;margin-bottom: 0.3em;"
            class='btn btn-warning actionBtn' 
            data-bs-toggle='modal' 
            data-bs-target='#updateModalTopic'
            onclick="getUpdateDataTopic(this)">
            <i class="fa fa-edit"></i>
    </button>
    <button 
            type='button' 
            style="width: 60px"
            class='btn btn-danger actionBtn'
            data-bs-toggle="modal" 
            data-bs-target="#deleteDialogTopic"
            onclick="deleteButton(this)">
            <i class="fa fa-trash"></i>
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
  uForm[2].value = updateData[3].innerHTML
  uForm[3].valueAsDate = new Date(updateData[4].innerHTML)
  updateData[5].getElementsByTagName("input")[0].checked
    ? (uForm[4].checked = true)
    : (uForm[4].checked = false)
}

const getUpdateDataTopic = (element) => {
  let updateData =
    element.parentElement.parentElement.getElementsByTagName("td")
  idToupdate = element.parentElement.parentElement.getAttribute("data-uniqueid")
  let uForm = document
    .getElementById("updateFormTopic")
    .getElementsByClassName("update-control")
  uForm[0].value = updateData[0].innerHTML
  uForm[1].value = updateData[1].innerHTML
}

const successToast = () => {
  let toastLiveExample = document.getElementById("successToast")
  new bootstrap.Toast(toastLiveExample).show()
  $("#table").bootstrapTable("refresh")
  $("#tableTopic").bootstrapTable("refresh")
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

// function getIdToTaskTopic() {
//   let id_topic_position = document.getElementById('table').querySelector("tbody").querySelectorAll("tr").length
//   id_task = document.getElementById('table').querySelector("tbody").querySelectorAll("tr")[id_topic_position].getAttribute("data-uniqueid")
// }

function doPostTopic(event, form) {
  fetch(form.action, {
    method: "POST",
    body: new FormData(form),
  }).then((response) => {
    if (response.ok) {
      let formData = new FormData()
      formData.append("id_task", id_task)
      fetch("./api/taskTopic", {
        method: "POST",
        body: formData,
      }).then((response) => {
        if (response.ok) {
          id_task += 1
          successToast()
        } else {
          errorToast()
        }
      })
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

function addIdTopic(form) {
  const formData = new FormData(form)
  formData.append("id_topic", idToupdate)
  return formData
}

function doPutTopic(event, form) {
  fetch(form.action, {
    method: "PUT",
    body: addIdTopic(form),
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

function doDeleteTopic() {
  fetch(`./api/topic?id_topic=${idToDelete}`, {
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
