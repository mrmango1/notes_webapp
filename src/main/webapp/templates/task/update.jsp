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
              class="form-control update-control"
              name="title"
              id="uTitle"
              placeholder="Titulo"
            />
            <label for="uTitle">Titulo</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <textarea
              class="form-control update-control"
              placeholder="Descripcion"
              name="description"
              id="uDescription"
              style="height: 125px"
            ></textarea>
            <label for="uDescription">Descripcion</label>
          </div>
          <div class="form-floating">
            <select
              class="form-select update-control"
              aria-label=".form-select-sm example"
              name="importance"
            >
              <option selected value="Tomate tu tiempo">Tomate tu tiempo</option>
              <option value="No es importante">No es importante</option>
              <option value="Regular">Regular</option>
              <option value="Es importante">Es importante</option>
              <option value="Urgente">Urgente</option>
            </select>
            <label for="uImportance">Que tan importante es?</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <input
              type="date"
              class="form-control update-control"
              name="limit_date"
              id="uLimitDate"
              placeholder="Fecha Limite"
              required
            />
            <label for="uLimitDate">Fecha Limite</label>
          </div>
          <div class="form-check">
            <input
              class="form-check-input update-control"
              type="checkbox"
              value="true"
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
