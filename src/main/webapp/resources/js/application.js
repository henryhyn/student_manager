/**
 * Created by Henry on 15/8/10.
 */
$(document).ready(function () {
    $('input[name=keywords]').on('input propertychange', function (e) {
        var keywords = $(e.target).val();
        if (keywords.length < 1) {
            return;
        }
        $.ajax({
            url: 'dosearch',
            data: {
                keywords: keywords
            },
            success: function (response) {
                $('#output').html(response);
            },
            error: function (response) {
                console.log(response);
            }
        })
    });

    $('.tag').click(function (e) {
        var keywords = $(e.target).text();
        $('input[name=keywords]').val(keywords);
        $('input[name=keywords]').trigger('input');
        $('input[name=keywords]').trigger('propertychange');
    });
});
