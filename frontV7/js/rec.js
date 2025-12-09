const urlParams = new URLSearchParams(window.location.search);

const uso = urlParams.get('uso');
const pe = urlParams.get('pe');
const pisada = urlParams.get('pisada');
const genero = urlParams.get('genero');

const API_URL = "http://localhost:8080/api/tenis/filter";

async function carregarTenis() {
    try {
        const response = await fetch(`${API_URL}?uso=${uso}&pe=${pe}&pisada=${pisada}&genero=${genero}`);
        const tenis = await response.json();

        console.log("TENIS RECEBIDOS:", tenis);

        renderizarCarrossel(tenis);

    } catch (err) {
        console.error("Erro ao buscar tênis:", err);
    }
}

/*
function renderizarCarrossel(lista) {
    const carousel = document.getElementById("carousel");
    carousel.innerHTML = ""; // limpa o conteúdo inicial

    lista.forEach((t, index) => {
        const card = document.createElement("div");
        card.classList.add("card");
        card.style.animationDelay = `${index * 0.1}s`;

        card.innerHTML = `
            <img src="${t.img}" alt="${t.nome}" class="main-img">

            <h2>${t.nome}</h2>
            <p>${t.descricao}</p>

            <div class="small-images">
                <div class="logo-item">
                    <span class="logo-label">Loja:</span>
                    <img src="imgs/logos/${t.loja.nome.toLowerCase()}_logo.png" alt="${t.loja.nome}">
                </div>
                <div class="logo-item">
                    <span class="logo-label">Marca:</span>
                    <img src="imgs/logos/${t.marca.nome.toLowerCase()}_logo.png" alt="${t.marca.nome}">
                </div>
            </div>

            <button onclick="window.open('${t.link}', '_blank')">Comprar</button>
        `;

        carousel.appendChild(card);
    });
}
*/

//versão alterada para testes de responsividade
function renderizarCarrossel(lista) {
    const carousel = document.getElementById("carousel");
    carousel.innerHTML = "";

    lista.forEach((t, index) => {
        const card = document.createElement("div");
        card.classList.add("card");
        card.style.animationDelay = `${index * 0.1}s`;

        card.innerHTML = `
            <img src="${t.img}" alt="${t.nome}" class="main-img">

            <h2>${t.nome}</h2>
            <p>${t.descricao}</p>

            <div class="small-images">
                <div class="logo-item">
                    <span class="logo-label">Loja:</span>
                    <img src="imgs/logos/${t.loja.nome.toLowerCase()}_logo.png" alt="${t.loja.nome}">
                </div>
                <div class="logo-item">
                    <span class="logo-label">Marca:</span>
                    <img src="imgs/logos/${t.marca.nome.toLowerCase()}_logo.png" alt="${t.marca.nome}">
                </div>
            </div>

            <button onclick="window.open('${t.link}', '_blank')">Comprar</button>
        `;

        carousel.appendChild(card);
    });

    const totalMinimo = 6;
    const faltantes = totalMinimo - lista.length;

    for (let i = 0; i < faltantes; i++) {
        const placeholder = document.createElement("div");
        placeholder.classList.add("card", "placeholder");

        placeholder.innerHTML = `
            <img src="imgs/others/teniscan_logo.png" alt="placeholder" class="main-img">
            <h2>Indisponível</h2>
            <p>Mais produtos em breve...</p>

            <div class="small-images">
                <div class="logo-item">
                    <span class="logo-label">Loja:</span>
                    <img src="imgs/others/teniscan_logo.png" alt="placeholder">
                </div>
                <div class="logo-item">
                    <span class="logo-label">Marca:</span>
                    <img src="imgs/others/teniscan_logo.png" alt="placeholder">
                </div>
            </div>

            <button disabled>Indisponível</button>
        `;

        carousel.appendChild(placeholder);
    }
}

// Funcionalidade de Feedback
function inicializarFeedback() {
    const feedbackForm = document.getElementById('feedbackForm');
    const feedbackSuccess = document.getElementById('feedbackSuccess');
    const ratingInputs = document.querySelectorAll('.feedback-rating input[type="radio"]');
    const ratingLabels = document.querySelectorAll('.feedback-rating label');

    // Adiciona interatividade visual às estrelas
    ratingLabels.forEach((label, index) => {
        label.addEventListener('mouseenter', () => {
            for (let i = 0; i <= index; i++) {
                ratingLabels[i].style.filter = 'grayscale(0%) opacity(1)';
            }
        });

        label.addEventListener('mouseleave', () => {
            const checked = document.querySelector('.feedback-rating input[type="radio"]:checked');
            if (checked) {
                const checkedIndex = Array.from(ratingInputs).indexOf(checked);
                ratingLabels.forEach((l, i) => {
                    if (i <= checkedIndex) {
                        l.style.filter = 'grayscale(0%) opacity(1)';
                    } else {
                        l.style.filter = 'grayscale(100%) opacity(0.5)';
                    }
                });
            } else {
                ratingLabels.forEach(l => {
                    l.style.filter = 'grayscale(100%) opacity(0.5)';
                });
            }
        });

        label.addEventListener('click', () => {
            ratingLabels.forEach((l, i) => {
                if (i <= index) {
                    l.style.filter = 'grayscale(0%) opacity(1)';
                    l.style.transform = 'scale(1.1)';
                } else {
                    l.style.filter = 'grayscale(100%) opacity(0.5)';
                    l.style.transform = 'scale(1)';
                }
            });
        });
    });

    // Reset visual quando um input é marcado
    ratingInputs.forEach((input, index) => {
        input.addEventListener('change', () => {
            ratingLabels.forEach((l, i) => {
                if (i <= index) {
                    l.style.filter = 'grayscale(0%) opacity(1)';
                    l.style.transform = 'scale(1.1)';
                } else {
                    l.style.filter = 'grayscale(100%) opacity(0.5)';
                    l.style.transform = 'scale(1)';
                }
            });
        });
    });

    // Envio do formulário
    feedbackForm.addEventListener('submit', async (e) => {
        e.preventDefault();

        const rating = document.querySelector('.feedback-rating input[type="radio"]:checked');

        if (!rating) {
            alert('Por favor, selecione uma avaliação!');
            return;
        }

        const feedbackData = {
            nota: Number(rating.value),
            uso: {id:Number(uso)},
            pe: {id:Number(pe)},
            pisada: {id:Number(pisada)},
            genero: {id:Number(genero)}
        };

        try {
            const response = await fetch('http://localhost:8080/api/feedbacks', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(feedbackData)
            });

            console.log('Feedback enviado:', feedbackData);

            // Mostra mensagem de sucesso
            feedbackSuccess.classList.add('show');
            feedbackForm.reset();
            
            // Reset visual das estrelas
            ratingLabels.forEach(l => {
                l.style.filter = 'grayscale(100%) opacity(0.5)';
                l.style.transform = 'scale(1)';
            });

            // Esconde a mensagem após 5 segundos
            setTimeout(() => {
                feedbackSuccess.classList.remove('show');
            }, 5000);

        } catch (err) {
            console.error('Erro ao enviar feedback:', err);
            alert('Erro ao enviar feedback. Tente novamente.');
        }
    });
}

// Inicializa quando a página carregar
carregarTenis();

// Aguarda o DOM estar pronto para inicializar o feedback
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', inicializarFeedback);
} else {
    inicializarFeedback();
}