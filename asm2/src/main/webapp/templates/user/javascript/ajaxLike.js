$('#dislike').click(function() {
	var href = $('#videoIdHiddent').val()
	console.log(href);
	$.ajax(function(){
		url: 'dislike?href=' + href;
	}).then(function() {
		alert("ThanhCong" + err);
	}).fail(function(err){
		alert("Do Again" + err);
	})
});

$('#like').appendEvent(onclick, function() {

});