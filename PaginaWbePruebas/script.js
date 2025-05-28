document.addEventListener("DOMContentLoaded", () => {
  const apiUrl = "http://172.16.30.231:8081/api/pizzas";

  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error(`Error al cargar datos: ${response.status}`);
      }
      return response.json();
    })
    .then(data => {
      mostrarPizzas(data);
    })
    .catch(error => {
      document.getElementById("pizzas").textContent = "Error al cargar pizzas.";
      console.error("Error en fetch:", error);
    });
});

function mostrarPizzas(pizzas) {
  const contenedor = document.getElementById("pizzas");
  contenedor.innerHTML = "";

  pizzas.forEach(pizza => {
    const div = document.createElement("div");
    div.classList.add("tarjeta-pizza");
    div.innerHTML = `
      <h3>${pizza.nombre}</h3>
      <p><strong>Ingredientes:</strong> ${pizza.ingredientes.join(", ")}</p>
      <p><strong>Precio:</strong> ${pizza.precio.toFixed(2)} €</p>
    `;
    contenedor.appendChild(div);
  });
}
