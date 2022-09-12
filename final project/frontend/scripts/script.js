const HOST = "http://localhost:8070"


function createAccount(){
    const email = document.getElementById('user-email').value;
    const name = document.getElementById('user-name').value;
    const age = document.getElementById('user-age').value;
    const password = document.getElementById('user-password').value;

    $.ajax({
        method: "post",
        url : `${HOST}/user`,
        data : JSON.stringify({
            "name": name,
            "email" : email,
            "age" : age,
            "password": password
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    }).done((response) => {
        alert('user created with id = ' + response)
    }).fail((xhrObj, textStatus) =>{
        //An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message)
            alert(xhrObj.responseJSON.message);
        if (xhrObj && xhrObj.responseText){
            alert(xhrObj.responseText);
        }    
        if (xhrObj){
            alert('error happened');
        }  
    })


}

function getAccount(){
    $.ajax({
        method: "get",
        url : `${HOST}/user`,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    }).done((response) =>{
        document.getElementById('user-email').value= response.email;
        document.getElementById('user-name').value= response.name;
        document.getElementById('user-age').value= response.age;
        document.getElementById('user-password').value= response.password;
    }).fail((xhrObj, textStatus) =>{
        //An error is 400 or 500 comes from API
        if (xhrObj && xhrObj.responseJSON && xhrObj.responseJSON.message)
            alert(xhrObj.responseJSON.message);
        if (xhrObj && xhrObj.responseText){
            alert(xhrObj.responseText);
        }   
        if (xhrObj){
            alert('error happened');
        }   
    })
}
