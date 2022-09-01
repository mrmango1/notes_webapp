<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<section>
  <div
          class="modal fade"
          id="deleteDialogTopic"
          data-bs-backdrop="static"
          data-bs-keyboard="false"
          tabindex="-1"
          aria-labelledby="staticBackdropLabel"
          aria-hidden="true">

      <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Confirmar</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                ¿Esta seguro que desea eliminar?
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-danger" id="deleteBtn" onclick="doDeleteTopic()">Confirmar</button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              </div>
          </div>
      </div>
  </div>
</section>