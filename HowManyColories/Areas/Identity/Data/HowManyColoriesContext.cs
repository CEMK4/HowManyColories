using HowManyColories.Areas.Identity.Data;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using HowManyColories.Models;

namespace HowManyColories.Areas.Identity.Data;

public class HowManyColoriesContext : IdentityDbContext<User>
{
    public HowManyColoriesContext(DbContextOptions<HowManyColoriesContext> options)
        : base(options)
    {
    }

    protected override void OnModelCreating(ModelBuilder builder)
    {
        base.OnModelCreating(builder);
        // Customize the ASP.NET Identity model and override the defaults if needed.
        // For example, you can rename the ASP.NET Identity table names and more.
        // Add your customizations after calling base.OnModelCreating(builder);
        builder.ApplyConfiguration(new UserEntityConfiguration());
    }

    public DbSet<HowManyColories.Models.Meal> Meal { get; set; } = default!;

    public DbSet<HowManyColories.Models.Product> Product { get; set; } = default!;
}

internal class UserEntityConfiguration : IEntityTypeConfiguration<User>
{
    public void Configure(EntityTypeBuilder<User> builder)
    {        
    }
}