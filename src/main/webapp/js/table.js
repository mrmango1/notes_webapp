let id_table = null 
let idToDelete = null

const getTables = async () => {
  const response = await fetch("./api/table")
  const data = await response.json()
  return data
}

function viewTable(id) {
  fetch("./currentTable", {
    method: "POST",
    headers: {
      Accept: "text/html",
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: `id_table=${id}`,
  }).then((response) => {
    if (response.ok) {
      window.location.assign("./task.jsp")
    } else {
      errorToast()
    }
  })
}

function editTable(element, id){
  id_table = id
  getUpdateData(element)
}

function deleteTable(id){
  idToDelete = id
}

const getUpdateData = (element) => {
  let uForm = document
  .getElementById("updateForm")
  .getElementsByClassName("form-control")
  updateData = element.parentElement.parentElement.children
  uForm[0].value = updateData[0].innerHTML
  uForm[1].value = updateData[1].innerHTML
}

const successToast = () => {
  let toastLiveExample = document.getElementById("successToast")
  new bootstrap.Toast(toastLiveExample).show()
  $("#table").bootstrapTable("refresh")
  $(".modal").modal("hide")
  writeTables()
}

const errorToast = () => {
  let toastLiveExample = document.getElementById("errorToast")
  let toast = new bootstrap.Toast(toastLiveExample)
  toast.show()
}

async function writeTables() {
  const data = await getTables()
  const tables = document.getElementById("response")
  tables.innerHTML = ""
  data.forEach((row) => {
    const div = document.createElement("div")
    div.classList.add("card", "text-bg-secondary", "mb-3")
    div.setAttribute("style", "width: 18rem;")
    div.innerHTML = `
        <div 
          class="card-header" 
          onclick="viewTable(${row.id_table})">
          Ver Notas
        </div>
        <div class="card-body">
            <h5 class="card-title">${row.title}</h5>
            <p class="card-text">${row.description}</p>
            <div>
                <button 
                  class="btn btn-primary"
                  data-bs-toggle='modal' 
                  data-bs-target='#updateModal'
                  onclick="editTable(this,${row.id_table})">
                  Editar
                  </button>
                <button 
                  class="btn btn-danger"
                  data-bs-toggle="modal" 
                  data-bs-target="#deleteDialog"
                  onclick="deleteTable(${row.id_table})">
                  Eliminar
                </button>
            </div>
        </div>
        `
    tables.appendChild(div)
  })
}
writeTables()

function doPost(event, form) {
  fetch(form.action, {
    method: "POST",
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

const addIdTable = (form) => {
  const formData = new FormData(form)
  formData.append("id_table", id_table)
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
  fetch(`./api/table?id_table=${idToDelete}`, {
    method: "DELETE",
  }).then((response) => {
    if (response.ok) {
      successToast()
    } else {
      errorToast()
    }
  })
}
