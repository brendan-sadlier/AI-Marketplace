$(document).ready(function() {
    var cartBadge = $('#cartCount');
    var addToCartButton = $('#addToCartButton');

    // Retrieve cart count from localStorage on page load
    var cartCount = parseInt(localStorage.getItem('cartCount')) || 0;
    cartBadge.text(cartCount);

    addToCartButton.click(function() {
        var quantity = parseInt($('#inputQuantity').val());
        if(quantity < 0)
            exit;

        // Update cart count and store it in localStorage
        var currentCount = parseInt(cartBadge.text());
        var newCount = currentCount + quantity;
        cartBadge.text(newCount);
        localStorage.setItem('cartCount', newCount);
    });
});

$(document).ready(function() {
    var cartBadge = $('#cartCount');

    // check if cartCount cookie exists and set it as the initial count
    if (Cookies.get('cartCount')) {
        cartBadge.text(Cookies.get('cartCount'));
    }

    $('button[data-sku]').click(function() {
        var quantity = parseInt($('#inputQuantity').val());
        if(quantity < 0)
            exit;
        var currentCount = parseInt(cartBadge.text());
        var newCount = currentCount + quantity;
        cartBadge.text(newCount);
        // set cartCount cookie with the new count value
        Cookies.set('cartCount', newCount);
    });
});