function Shape(x, y, w, h, fill)
{
    this.x = x || 0;
    this.y = y || 0;
    this.w = w || 1;
    this.h = h || 1;
    this.fill = fill || '#659eed';
}


Shape.prototype.draw = function(ctx)
{
    ctx.fillStyle = this.fill;
    ctx.fillRect(this.x, this.y, this.w, this.h);
}

