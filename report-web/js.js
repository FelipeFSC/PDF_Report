
var contCompetenciasId = 1;
var contCertificacoesId = 1;

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