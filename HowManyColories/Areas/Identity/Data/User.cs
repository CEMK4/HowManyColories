using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using HowManyColories.Models;
using Microsoft.AspNetCore.Identity;

namespace HowManyColories.Areas.Identity.Data;

// Add profile data for application users by adding properties to the User class
public class User : IdentityUser
{
    public int? Age { get; set; }
    public int? Height { get; set; }
    public int? Weight { get; set; }

    public virtual ICollection<Meal> Meals { get; set; }
}

