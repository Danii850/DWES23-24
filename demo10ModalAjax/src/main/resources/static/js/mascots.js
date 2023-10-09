function open_delete(id) : void {
    $.ajax({
        url: 'macota/delete/show/' + id,
        success: function(data) :void {
            $('#paraelmodal').html(data);
            $('#delete-modal').modal('show');
        }
    })
}