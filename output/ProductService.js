function getProducts() {
  return JSON.parse(localStorage.getItem("products")) || [
    { id: 1, name: "HP Laptop", description: "Brand new HP Laptop with Intel i7 processor", image: "https://images.pexels.com/photos/7974/pexels-photo.jpg", price: 3500 },
    { id: 2, name: "iPhone", description: "iPhone 14 Pro with advanced camera system", image: "https://images.pexels.com/photos/7974/pexels-photo.jpg", price: 4500 },
    { id: 3, name: "AirPods", description: "Wireless Apple AirPods", image: "https://images.pexels.com/photos/7974/pexels-photo.jpg", price: 800 }
  ];
}
function addProduct() {
const product={name:document.getElementById("name").value,
description:document.getElementById("description").value,
image:document.getElementById("image").value,
price:document.getElementById("price").value,
}const products = getProducts();
const newProduct = {... product, id:generateId()};
products.push(newProduct);
  localStorage.setItem("products", JSON.stringify(products));
}
function updateProduct() {
const updatedProduct={id:id,name:document.getElementById("name").value,
description:document.getElementById("description").value,
image:document.getElementById("image").value,
price:document.getElementById("price").value,
}const products = getProducts();
const index = products.findIndex((p) => p.id === updatedProduct.id);
if (index !== -1) {
products[index] = updatedProduct;
}
  localStorage.setItem("products", JSON.stringify(products));
}
function deleteProduct(id) {
const products = getProducts();
const updatedProducts = products.filter((p) => p.id !== id)
  localStorage.setItem("products", JSON.stringify(updatedProducts));
}
function getProduct(id) {
return getProducts().find((p) => p.id === id);
}
function generateId() {
return Math.floor(Math.random() * 1000);
}
