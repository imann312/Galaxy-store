// cart.js
let cart = [];

// Function to add items to the cart
function addToCart(product) {
    cart.push(product);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCart();
}

// Function to update the cart display
function updateCart() {
    const cartElement = document.getElementById('cart');
    if (cartElement) {
        cartElement.innerHTML = '';

        cart.forEach((item, index) => {
            const itemElement = document.createElement('div');
            itemElement.textContent = `${index + 1}. ${item}`;
            cartElement.appendChild(itemElement);
        });

        updateWhatsAppLink();
    }
}

// Function to update the WhatsApp link with cart details
function updateWhatsAppLink() {
    const whatsappLink = document.getElementById('whatsapp-link');
    if (whatsappLink) {
        const message = `Order Details:\n${cart.join('\n')}`;
        const encodedMessage = encodeURIComponent(message);
        whatsappLink.href = `https://wa.me/YOUR_PHONE_NUMBER?text=${encodedMessage}`;
    }
}

// Event listener for adding items to the cart
document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', (event) => {
        const product = event.target.dataset.product;
        addToCart(product);
    });
});

// Initialize the cart from localStorage
document.addEventListener('DOMContentLoaded', () => {
    const storedCart = localStorage.getItem('cart');
    if (storedCart) {
        cart = JSON.parse(storedCart);
        updateCart();
    }

    // Search functionality
    const searchInput = document.getElementById('search-input');
    searchInput.addEventListener('input', (event) => {
        const searchTerm = event.target.value.toLowerCase();
        const cards = document.querySelectorAll('.card');

        cards.forEach(card => {
            const productName = card.querySelector('h2').textContent.toLowerCase();
            const productDescription = card.querySelector('p').textContent.toLowerCase();

            if (productName.includes(searchTerm) || productDescription.includes(searchTerm)) {
                card.style.display = 'flex';
            } else {
                card.style.display = 'none';
            }
        });
    });
});
