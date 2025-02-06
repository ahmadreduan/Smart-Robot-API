const apiUrl = 'http://localhost:8080';

async function createOrder() {
    const locationCode = document.getElementById('locationCode').value;

    if (!locationCode) {
        alert('Please enter a location code.');
        return;
    }

    try {
        const response = await fetch(`${apiUrl}/api/orders/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ locationCode }), // Shortened Syntax
        });

        if (response.ok) {
            const data = await response.json();
            document.getElementById('orderLocationCode').innerText = data.locationCode;
            document.getElementById('orderPin').innerText = data.pin;

            document.getElementById('orderForm').style.display = 'none';
            document.getElementById('orderInfo').style.display = 'block';
            document.getElementById('verifyPinForm').style.display = 'block';
        } else {
            alert('Error creating order!');
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Failed to connect to the server.');
    }
}















// const apiUrl = 'http://localhost:8080'; // Change this to your backend URL
//
// // Function to create a new order
// async function createOrder() {
//     const locationCode = document.getElementById('locationCode').value;
//
//     if (!locationCode) {
//         alert('Please enter a location code.');
//         return;
//     }
//
//     try {
//         const response = await fetch(`${apiUrl}/api/orders`, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify({ locationCode: locationCode }),
//         });
//
//         if (response.ok) {
//             const data = await response.json();
//             document.getElementById('orderLocationCode').innerText = data.locationCode;
//             document.getElementById('orderPin').innerText = data.pin;
//
//             // Hide order creation form and show order info
//             document.getElementById('orderForm').style.display = 'none';
//             document.getElementById('orderInfo').style.display = 'block';
//             document.getElementById('verifyPinForm').style.display = 'block';
//         } else {
//             alert('Error creating order!');
//         }
//     } catch (error) {
//         alert('Failed to connect to the server.');
//     }
// }
//
// // Function to verify pin
// async function submitPin() {
//     const locationCode = document.getElementById('orderLocationCode').innerText;
//     const pin = document.getElementById('pinInput').value;
//
//     if (!pin) {
//         alert('Please enter a pin.');
//         return;
//     }
//
//     try {
//         const response = await fetch(`${apiUrl}/api/orders/verify?locationCode=${locationCode}&pin=${pin}`, {
//             method: 'POST',
//         });
//
//         if (response.ok) {
//             alert('Package delivered successfully!');
//             document.getElementById('orderInfo').style.display = 'none';
//         } else {
//             alert('Invalid pin. Please try again.');
//         }
//     } catch (error) {
//         alert('Failed to connect to the server.');
//     }
// }
