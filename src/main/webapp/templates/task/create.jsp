<section>
  <div
    class="modal fade"
    id="createModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">
            Crea una nueva tarea
          </h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <form
          id="createForm"
          action="api/task"
          onsubmit="doPost(event,this)"
          class="modal-body"
        >
          <div class="form-floating mb-3 mt-3">
            <input
              type="text"
              class="form-control"
              name="title"
              id="cTitle"
              placeholder="Titulo"
            />
            <label for="cTitle">Titulo</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <textarea
              class="form-control"
              placeholder="Descripcion"
              name="description"
              id="cDescription"
              style="height: 125px"
            ></textarea>
            <label for="cDescription">Descripcion</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <input
              type="number"
              max="4"
              min="0"
              class="form-control"
              name="importance"
              id="cImportance"
              placeholder="Imporancia"
            />
            <label for="cImportance">Importancia</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <input
              type="date"
              class="form-control"
              name="limit_date"
              id="cLimitDate"
              placeholder="Fecha Limite"
            />
            <label for="cLimitDate">Fecha Limite</label>
          </div>
        </form>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            Cancelar
          </button>
          <button type="submit" form="createForm" class="btn btn-primary">
            Crear
          </button>
        </div>
      </div>
    </div>
  </div>
</section>
