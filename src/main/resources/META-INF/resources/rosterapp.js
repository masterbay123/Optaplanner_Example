function refresh() {
    $("td").each(function() {
        if ($(this).length == 1 && $(this).attr("colspan") != 4) {
            $(this).text("");
        }
    });
};
function solve() {
    refresh();
    $("#stop").show();
    solvebutton(true);
    $.post("roster/solve",function(Roster) {
    $.each(Roster.shiftList,(index,shift) => {
        var newthis = $("tbody>tr").find($("td[class='"+ shift.location.location + "'][id='"+ shift.timeslot.month+ "']"));
        newthis.html("&#10004;");
    
    });
        $("#stop").hide();
        $("#solve").show();
    }).fail(function (xhr, ajaxOptions, thrownError) {
        console.log("Start solving failed.", xhr.responseText);
    });
};

function solvebutton(solvebuttonstatus) {
    (solvebuttonstatus == true) ? $("#solve").hide() : console.log(undefined);
    solvebuttonstatus = false;
    return solvebuttonstatus;
};

function stopsolving() {
    $.post("roster/stopsolve",function() {
        $("#stop").hide();
        $("#solve").show();
    });
}

$(function () {
    $.getJSON("roster/getRoster", function (Roster) {
        $()
        var getTable = $("#RosterTable");
        var getHeader = $("<thead>").appendTo(getTable);
        var getrow = $("<tr>").appendTo(getHeader);
        getrow.append($("<th>").append("Id").append($("</th>")));
        getrow.append($("<th colspan='4'>").append("Location").append($("</th>")));
        $.each(Roster.timeslotList, (index, month) => {
            getrow.append($("<th class='" + month.month + "'>").append(month.month).append($("</th>")));
        });
        getrow.append($("</tr>"));
        var getBody = getTable.append($("<tbody>"));
        $.each(Roster.locationList, (index, location) => {
            getBody.append($("<tr class='" + location.location + "'>").append($("<th scope='row'>").append(location.id).append($("</th>"))).append(($("<td colspan='4' class='" + location.location + "'>")).append(location.location).append($("</td>"))));

        });
        $.each(Roster.locationList, (index, location) => {
            var gethis = $("tbody>tr[class='" + location.location + "']");
            $.each(Roster.timeslotList, (index, month) => {
                gethis.append($("<td class='" + location.location + "' id='" + month.month + "'>"));
            });
        });
    });
    $("#solve").click(function() {
        solve();
    })
    $("#stop").click(function() {
        stopsolving();
    });
});