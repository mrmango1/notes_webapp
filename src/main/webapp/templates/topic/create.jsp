<section>
  <div
    class="modal fade"
    id="createModalTopic"
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
            Crea un nuevo Asunto
          </h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <form
          id="createFormTopic"
          action="api/topic"
          onsubmit="doPost(event,this)"
          class="modal-body"
        >
          <div class="form-floating mb-3 mt-3">
            <input
              type="text"
              class="form-control"
              name="name"
              id="cNameTopic"
              placeholder="Nombre"
            />
            <label for="cNameTopic">Nombre</label>
          </div>
          <div class="form-floating mb-3 mt-3">
            <textarea
              class="form-control"
              placeholder="Descripcion"
              name="description"
              id="cDescriptionTopic"
              style="height: 125px"
            ></textarea>
            <label for="cDescriptionTopic">Descripcion</label>
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
          <button type="submit" form="createFormTopic" class="btn btn-primary">
            Crear
          </button>
        </div>
      </div>
    </div>
  </div>
</section>
