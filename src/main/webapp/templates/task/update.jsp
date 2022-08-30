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
          action="api/table"
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
          <select
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            name="color"
          >
            <option selected value="teal">Teal</option>
            <option value="foam">Foam</option>
            <option value="peach">Peach</option>
            <option value="marron">Marron</option>
            <option value="lavender">Lavender</option>
            <option value="rosewater">Rosewater</option>
            <option value="mauve">Mauve</option>
            <option value="dark">Dark</option>
          </select>
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
