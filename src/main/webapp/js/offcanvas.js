var toggle = document.getElementById("toggleSidebar")
var offcanvas_el = document.getElementById("offcanvasExample")
var offcanvas = new bootstrap.Offcanvas(offcanvas_el, {backdrop: false, scroll: true})

toggle.addEventListener("change", function(){
    toggle.checked ? offcanvas.show() : offcanvas.hide() 
})

// handle case when sidebar is closed internally using `X`
offcanvas_el.addEventListener('hide.bs.offcanvas', function () {
    toggle.checked = false
})