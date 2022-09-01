<section>
  <div
    class="modal fade"
    id="updateModalTopic"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Actualizar Asunto</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <form
          id="updateFormTopic"
          action="api/topic"
          onsubmit="doPutTopic(event,this)"
          class="modal-body"
        >
          <div class="form-floating mb-3 mt-3">
            <input
              type="text"
              class="form-control update-control"
              name="name"
              id="uNameTopic"
              placeholder="Nombre"
            />
            <label for="uNameTopic">Nombre</label>
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
        </form>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            Cancelar
          </button>
          <button type="submit" form="updateFormTopic" class="btn btn-primary">
            Actualizar
          </button>
        </div>
      </div>
    </div>
  </div>
</section>
