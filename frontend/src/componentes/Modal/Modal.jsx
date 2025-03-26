import React from 'react'
import './Modal.css'

const Modal = () => {
    return (
        <div className='modal-container'>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Adicionar um novo registro
            </button>


            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Novo Registro</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="mb-3">
                                    <label for="input-cliente" class="col-form-label">Cliente:</label>
                                    <input type="text" class="form-control" id="input-cliente" />
                                </div>
                                <div class="mb-3">
                                    <label for="input-valor" class="col-form-label">Valor:</label>
                                    <input type="text" class="form-control" id="input-valor" />
                                </div>
                                <div class="mb-3">
                                    <label for="input-margem" class="col-form-label">Margem:</label>
                                    <input type="text" class="form-control" id="input-margem" />
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary">Salvar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Modal
