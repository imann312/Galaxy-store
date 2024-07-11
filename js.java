gsap.timeline()
    .from("#card-1", {
        y: 100,
        x: -100,
        opacity: 0,
        duration: 1,
        ease: "back"
    })
    .from("#card-2", {
        y: 100,
        x: -100,
        opacity: 0,
        duration: 0.5,
        stagger: 0.25,
        ease: "ease"
    }, "-=.75")
    .from("#card-3", {
        y: 100,
        x: -100,
        opacity: 0,
        scale: 0,
        ease: "back"
    }, "-=.85");
