
var contCompetenciasId = 1;
var contCertificacoesId = 1;
var contIdiomasId = 1;
var contIdExperiencia = 1;

function addCompentecia() {
    let divCompentecias = document.getElementById("competencias");
    let nomeCompetencia = document.getElementById("nomeCompetencia").value;

    if (nomeCompetencia.length < 1) {
        return;
    }

    divCompentecias.innerHTML += `
        <div class="input-group mb-3" id="divCompetencia${contCompetenciasId}">
            <input class="form-control" type="text" placeholder="${nomeCompetencia}" aria-label="Disabled input example" disabled>
            <button class="btn btn-outline-danger" type="button" id="button-addon2" onclick="removeCompetencia(${contCompetenciasId})">Remover</button>
        </div>
    `;

    document.getElementById("nomeCompetencia").value = "";
    contCompetenciasId++;
}

function removeCompetencia(divId) {
    document.getElementById("divCompetencia" + divId).remove();
}


function addCertificacao() {
    let divCertificacoes = document.getElementById("certicacoes");
    let nomeCertificacao = document.getElementById("nomeCertificacao").value;

    if (nomeCertificacao.length < 1) {
        return;
    }

    divCertificacoes.innerHTML += `
        <div class="input-group mb-3" id="divCertificacao${contCertificacoesId}">
            <input class="form-control" type="text" placeholder="${nomeCertificacao}" aria-label="Disabled input example" disabled>
            <button class="btn btn-outline-danger" type="button" id="button-addon2" onclick="removeCertificacao(${contCertificacoesId})">Remover</button>
        </div>
    `;

    document.getElementById("nomeCertificacao").value = "";
    contCertificacoesId++;
}

function removeCertificacao(divId) {
    document.getElementById("divCertificacao" + divId).remove();
}

function addIdioma() {
    let divIdiomas = document.getElementById("idiomas");
    let nomeIdioma = document.getElementById("nomeIdioma").value;

    if (nomeIdioma.length < 1) {
        return;
    }

    divIdiomas.innerHTML += `
        <div class="input-group mb-3" id="divCertificacao${contIdiomasId}">
            <input class="form-control" type="text" placeholder="${nomeIdioma}" aria-label="Disabled input example" disabled>
            <button class="btn btn-outline-danger" type="button" id="button-addon2" onclick="removeCertificacao(${contIdiomasId})">Remover</button>
        </div>
    `;

    document.getElementById("nomeIdioma").value = "";
    contIdiomasId++;
}

function removeIdioma(divId) {
    document.getElementById("divIdioma" + divId).remove();
}




function addExperiencia() {
    let divExperiencias = document.getElementById("experiencias");
    let nomeEmpresa = document.getElementById("nomeEmpresa").value;
    let nomeCargo = document.getElementById("nomeCargo").value;
    let nomeDataInicio = document.getElementById("nomeDataInicio").value;
    let nomeDataFim = document.getElementById("nomeDataFim").value;
    let nomeEndereco = document.getElementById("nomeEndereco").value;

    divExperiencias.innerHTML += `
            <div class="container-sm divExp" id="divExperiencia${contIdExperiencia}">
                ${nomeEmpresa} <br>
                ${nomeCargo} <br>
                ${nomeDataInicio} - ${nomeDataFim} <br>
                ${nomeEndereco}
                <div class="divBtnEditAndDelete">
                    <div class="d-grid gap-2 col-6 mx-auto divButtonCenter">
                        <span class="material-symbols-outlined btnEditHover">
                            edit
                        </span>
                    </div>
                    <div class="d-grid gap-2 col-6 mx-auto divButtonCenter" onclick="removeExperiencia(${contIdExperiencia})">
                        <span class="material-symbols-outlined btnDeleteHover">
                            delete
                        </span>
                    </div>
                </div>
           </div>
    `;
    document.getElementById("nomeEmpresa").value = "";
    document.getElementById("nomeCargo").value = "";
    document.getElementById("nomeDataInicio").value = "";
    document.getElementById("nomeDataFim").value = "";
    document.getElementById("nomeEndereco").value = "";
    contIdExperiencia++;
}

function removeExperiencia(divId) {
    document.getElementById("divExperiencia" + divId).remove();
}

function addFormacao() {
    
}


