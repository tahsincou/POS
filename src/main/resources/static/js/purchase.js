// purchase.js

function fetchPurchases() {
    var selectedDate = $("#date").val();

    $.ajax({
        url: "/purchase",
        method: "GET",
        data: { date: selectedDate },
         success: function(html) {
            // Update the content of a container with the received HTML
            $("#purchaseTable").html(html);
        },
        error: function(xhr, status, error) {
            console.error("Error:", error);
        }
  
    });
}

function handleFormSubmit() {
    // Clear input fields (excluding the date input)
    $("#purchaseForm :input[type=text]").not("#date").val('');
}


function saveAndRefreshTable() {
    $.ajax({
        url: "/purchase/save",
        method: "POST",
        data: $("#purchaseForm").serialize(),
         success: function(html) {
            // Update the content of a container with the received HTML
            handleFormSubmit();
            $("#purchaseTable").html(html);
        },
        error: function(xhr, status, error) {
            console.error("Error:", error);
        }
    });
}
