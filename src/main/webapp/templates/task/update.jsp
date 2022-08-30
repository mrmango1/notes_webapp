<section>
  <div
    class="modal fade"
    id="updateModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Actualizar Tabla</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <form
          id="updateForm"
          action="api/task"
          onsubmit="doPut(event,this)"
          class="modal-body"
        >
          <div class="form-floating mb-3 mt-3">
            <input
              type="text"
              class="form-control"
              name="title"
              id="uTitle"
              placeholder="Titulo"
            />
            <label for="uTitle">Titulo</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <textarea
              class="form-control"
              placeholder="Descripcion"
              name="description"
              id="uDescription"
              style="height: 125px"
            ></textarea>
            <label for="uDescription">Descripcion</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <input
              type="number"
              max="4"
              min="0"
              class="form-control"
              name="importance"
              id="uImportance"
              placeholder="Imporancia"
            />
            <label for="uImportance">Importancia</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <input
              type="datetime-local"
              class="form-control"
              name="limit_date"
              id="uLimitDate"
              placeholder="Fecha Limite"
            />
            <label for="uLimitDate">Fecha Limite</label>
          </div>
          <div class="form-check">
            <input type="hidden" name="done" value="0" />
            <input
              class="form-check-input"
              type="checkbox"
              value="1"
              name="done" 
              id="doneCheckbox"
            />
            <label class="form-check-label" for="doneCheckbox">
              Tarea Finalizada
            </label>
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
          <button type="submit" form="updateForm" class="btn btn-primary">
            Actualizar
          </button>
        </div>
      </div>
    </div>
  </div>
</section>
