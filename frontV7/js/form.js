document.addEventListener('DOMContentLoaded', () => {

    carregarDados();

    const selects = ['select1', 'select2', 'select3', 'select4'];
    const helpButtons = document.querySelectorAll('.help-btn');
    const tooltips = document.querySelectorAll('.tooltip');
    let formTouched = false;

    function updateWarnings() {
        document.querySelectorAll('.field').forEach(field => {
            const select = field.querySelector('select');
            const warning = field.querySelector('.warning');

            if (!formTouched) {
                warning.classList.add("hidden");
                return;
            }

            if (select.value === "") {
                warning.classList.remove("hidden");
            } else {
                warning.classList.add("hidden");
            }
        });
    }

    document.getElementById("submitButton").addEventListener("click", (e) => {
        e.preventDefault();

        formTouched = true;
        updateWarnings();

        const selects = ['select2', 'select4', 'select3', 'select1']; // ordem: uso, pe, pisada, genero
        const invalid = selects.some(id => document.getElementById(id).value === "");

        if (!invalid) {
            // Pega os valores dos selects
            const params = selects.map(id => document.getElementById(id).value);

            // Monta a URL com query string
            const queryString = `?uso=${params[0]}&pe=${params[1]}&pisada=${params[2]}&genero=${params[3]}`;
            window.location.href = `recomendacoes.html${queryString}`;
        }
    });

    selects.forEach(id => {
        document.getElementById(id).addEventListener("change", updateWarnings);
    });

    helpButtons.forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.dataset.helpId;
            const tooltip = document.getElementById(id);

            tooltips.forEach(t => { if (t !== tooltip) t.classList.add('hidden'); });
            tooltip.classList.toggle('hidden');
        });
    });

    document.addEventListener('click', e => {
        if (!e.target.closest('.help-btn') && !e.target.closest('.tooltip')) {
            tooltips.forEach(t => t.classList.add('hidden'));
        }
    });
});

async function carregarDados() {
    try {
        const resp = await fetch("http://localhost:8080/api/tags");
        const dados = await resp.json();

        preencherSelect("select1", dados.filter(t => t.tipo === "genero"));
        preencherSelect("select2", dados.filter(t => t.tipo === "uso"));
        preencherSelect("select3", dados.filter(t => t.tipo === "pisada"));
        preencherSelect("select4", dados.filter(t => t.tipo === "pe"));

    } catch (error) {
        console.error("Erro ao carregar:", error);
    }
}

function preencherSelect(selectId, lista) {
    const select = document.getElementById(selectId);

    while (select.options.length > 1) {
        select.remove(1);
    }

    lista.forEach(item => {
        const option = document.createElement("option");
        option.value = item.id;
        option.textContent = item.nome;
        select.appendChild(option);
    });
}