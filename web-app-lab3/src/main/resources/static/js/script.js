$(function () {
        $(window).on('load', function () {
            if($.cookie('currentLocation') == null)
                $('#myModal').modal('show');
    });

    $('#priceToHigh').on('click', function () {
        $.get("/sortPrice/asc", function (data, status) {
            $('#productsContainer').replaceWith(data);
        })
    });
    $('#priceToLow').on('click', function () {
        $.get("/sortPrice/desc", function (data, status) {
            $('#productsContainer').replaceWith(data);
        })
    });

    $('#search').on('click', function () {
        var $checkedCheckboxes = $("#categories :checkbox:checked").closest("div.checkbox");
        var categ = $.map($checkedCheckboxes, function (val, i) {
            return $(val).prop("id");
        });
        $.get("/filter?categ=" + categ.join(), function (data, status) {
            $('#productsContainer').replaceWith(data);
        })
    });

    $('.addToCart').on('click', function () {
        let id = $(this).data('id');
        $.post("/addToCart?id=" + id, {
            dataType: 'json',
            data: '{"id": "' + id + '"}',
        }, function (data) {
        }).done(function (data) {
            $('#cartCount').html(data);
        }).fail(function () {
            alert('falled')
        })
    });

    $(".dropdown-menu li a").click(function() {
        $("#cityName").text($(this).text());
    });

    $('#saveCity').click(function () {
        let city = $("#cityName").html();
        if(city !== null)
            $.cookie("currentLocation", city);
    })
})
