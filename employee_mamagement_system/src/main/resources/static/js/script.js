const toggleSidebar = () => {
    if ($('.sidebar ').is(":visible")) {
        $('.sidebar').css('display', 'none');
        $('.content').css('margin-left', '0px');

    } else {
        $('.sidebar').css('display', 'block');
        $('.content').css('margin-left', '20%');
    }
};

// message 
function messagebar(cId) {
    swal({
            title: "Are you sure?",
            text: "Once deleted, you will not be able to recover this Contact!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                window.location = "/user/deleteContact/" + cId;
            } else {
                swal("Your Contact Is Safe!");
            }
        });
}


// for searching the contact
const search = () => {
    let query = $("#search-keyword").val();
    if (query == "") {
        $(".search-results").hide();
    } else {
        let url = `http://localhost:8080/search/${query}`;

        // to call the api
        fetch(url).then(response => {
            return response.json();
        }).then(data => {
            // here is the returned data from api call

            let text = `<div class="list-group">`;

            data.forEach(contact => {
                text += `<a href="/user/contact/${contact.con_id}" class="list-group-item my-1 list-group-item-action">
                ${contact.name}</a>`;
            })

            text += `</div>`;
            $('.search-results').html(text);
            $(".search-results").show();
        })

    }
}