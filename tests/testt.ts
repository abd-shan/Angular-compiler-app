import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [CommonModule, FormsModule, RouterModule],
    styles: [
        `
      .container {
        display: flex;
        margin: 0;
        padding: 20px;
        font-family: Arial, sans-serif;
      }

      .sidebar {
        width: 300px;
        padding: 20px;
        border-right: 2px solid #ccc;
        background-color: #f5f5f5;
      }

      .main-content {
        flex: 1;
        padding: 20px;
      }

      .product-form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin-bottom: 20px;
      }

      .product-form input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
      }

      .product-form button {
        background: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 10px;
      }

      .product-list {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
        gap: 20px;
      }

      .product-card {
        background: white;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 15px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      }

      .product-card img {
        width: 100%;
        height: 200px;
        object-fit: cover;
        border-radius: 4px;
        margin-bottom: 10px;
      }
      .product-card h3 {
        margin: 10px 0;
        color: #333;
      }

      .product-card p {
        color: #666;
        margin: 5px 0;
      }

      .product-card button {
        padding: 8px 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-right: 8px;
        margin-top: 10px;
      }

      .product-card button.edit {
        background: #28a745;
        color: white;
      }

      .product-card button.delete {
        background: #dc3545;
        color: white;
      }

      .tabs {
        display: flex;
        margin: 20px 0;
      }

      .tab {
        padding: 10px 20px;
        cursor: pointer;
        border: none;
        background: none;
        border-bottom: 2px solid transparent;
      }

      .tab.active {
        border-bottom-color: #007bff;
        color: #007bff;
      }

      .modal {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        display: flex;
        justify-content: center;
        align-items: center;
        z-index: 1000;
      }

      .modal-content {
        background: white;
        padding: 30px;
        border-radius: 8px;
        max-width: 500px;
        width: 90%;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
      }

      .modal-content img {
        width: 100%;
        max-width: 300px;
        height: auto;
        border-radius: 4px;
        margin: 15px 0;
      }
    `
    ],
    template: `
    <div class="container">
      <div class="sidebar">
        <h2>Add product</h2>

        <form class="product-form" (submit)="onSubmit($event)">
          <input type="text" placeholder="Product Name" [(ngModel)]="newProduct.name" name="name" required>
          <input type="text" placeholder="Product Description" [(ngModel)]="newProduct.description" name="description" required>
          <input type="text" placeholder="Image URL" [(ngModel)]="newProduct.image" name="image" required>
          <input type="number" placeholder="Price" [(ngModel)]="newProduct.price" name="price" required>
          <button type="submit">Add Product</button>
        </form>

        <div class="tabs">
          <button class="tab" [class.active]="currentRoute === '/products'" (click)="navigate('/products')">Products</button>
          <button class="tab" [class.active]="currentRoute === '/add'" (click)="navigate('/add')">Add</button>
        </div>
      </div>

      <div class="main-content">
        <div *ngIf="currentRoute === '/products'">
          <h2>Product List</h2>
          <div class="product-list">
            <div class="product-card" *ngFor="let product of products">
              <img [src]="product.image" [alt]="product.name">
              <h3>{{ product.name }}</h3>
              <p>{{ product.description }}</p>
              <p><strong>Price: {{ product.price }} SAR</strong></p>
              <button class="edit" (click)="showDetails(product.id)">View Details</button>
              <button class="edit" (click)="editProduct(product.id)">Edit</button>
              <button class="delete" (click)="deleteProduct(product.id)">Delete</button>
            </div>
          </div>
        </div>

        <div *ngIf="currentRoute === '/add'">
          <h2>Add New Product</h2>
          <form class="product-form">
            <input type="text" placeholder="Product Name" [(ngModel)]="newProduct.name" name="name" required>
            <input type="text" placeholder="Product Description" [(ngModel)]="newProduct.description" name="description" required>
            <input type="text" placeholder="Image URL" [(ngModel)]="newProduct.image" name="image" required>
            <input type="number" placeholder="Price" [(ngModel)]="newProduct.price" name="price" required>
            <button type="button" (click)="addProduct()">Add Product</button>
          </form>
        </div>

        <div *ngIf="selectedProduct" class="modal">
          <div class="modal-content">
            <h2>{{ selectedProduct.name }}</h2>
            <img [src]="selectedProduct.image" [alt]="selectedProduct.name">
            <p><strong>Description:</strong> {{ selectedProduct.description }}</p>
            <p><strong>Price:</strong> {{ selectedProduct.price }} SAR</p>
            <button (click)="closeModal()">Close</button>
          </div>
        </div>
      </div>
    </div>
  `,
})
export class AppComponent {
    products: any[] = [];
    selectedProduct: any = null;
    currentRoute: string = '/products';
    newProduct: any = {
        name: '',
        description: '',
        image: '',
        price: 0
    };

    constructor() {
        // Initialize with sample products
        this.products = [
            {
                id: 1,
                name: 'HP Laptop',
                description: 'Brand new HP Laptop with Intel i7 processor',
                image: 'https://images.pexels.com/photos/7974/pexels-photo.jpg',
                price: 3500
            },
            {
                id: 2,
                name: 'iPhone',
                description: 'iPhone 14 Pro with advanced camera system',
                image: 'https://images.pexels.com/photos/1647976/pexels-photo.jpg',
                price: 4500
            },
            {
                id: 3,
                name: 'AirPods',
                description: 'Wireless Apple AirPods',
                image: 'https://images.pexels.com/photos/3780681/pexels-photo.jpg',
                price: 800
            }
        ];
    }

    // Navigation Methods
    navigate(route: string) {
        this.currentRoute = route;
    }

    // Product Management Methods
    addProduct() {
        if (this.newProduct.name && this.newProduct.description && this.newProduct.image && this.newProduct.price) {
            const newProduct = {
                ...this.newProduct,
                id: this.products.length > 0 ? Math.max(...this.products.map(p => p.id)) + 1 : 1
            };
            this.products.push(newProduct);
            this.resetNewProduct();
            this.currentRoute = '/products';
        }
    }

    deleteProduct(productId: number) {
        this.products = this.products.filter(p => p.id !== productId);
    }

    editProduct(productId: number) {
        const product = this.products.find(p => p.id === productId);
        if (product) {
            this.newProduct = { ...product };
            this.navigate('/add');
        }
    }

    showDetails(productId: number) {
        this.selectedProduct = this.products.find(p => p.id === productId);
    }

    closeModal() {
        this.selectedProduct = null;
    }

    onSubmit(event: Event) {
        event.preventDefault();
        this.addProduct();
    }

    private resetNewProduct() {
        this.newProduct = {
            name: '',
            description: '',
            image: '',
            price: 0
        };
    }
}